package kg.build.flat_service.service.minio.impl;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import jakarta.transaction.Transactional;
import kg.build.flat_service.config.minio.MinioProperties;
import kg.build.flat_service.entity.file.Files;
import kg.build.flat_service.exception.files.FileNotFoundException;
import kg.build.flat_service.exception.files.MinioOperationException;
import kg.build.flat_service.repository.file.FilesRepository;
import kg.build.flat_service.service.minio.MinioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;
    private final MinioProperties minioProperties;
    private final FilesRepository repository;
    private final FilesRepository filesRepository;

    @Override
    public byte[] getFileById(Long id){
        Files file = findFileOrThrow(id);
        return downloadFromMinio(file.getPath());
    }

    @Override
    public List<byte[]> getFileByIds(List<Long> ids){
        List<Files> files = filesRepository.findAllByIdIn(ids);

        return ids.stream()
                .map(id -> files.stream()
                        .filter(f -> f.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new FileNotFoundException(id)))
                .map(f -> downloadFromMinio(f.getPath()))
                .toList();
    }

    @Override
    @Transactional
    public Files saveFile(MultipartFile file,String basePath, Long id){
        String uuid = UUID.randomUUID().toString();
        String originalName = file.getOriginalFilename() != null ? file.getOriginalFilename() : "unknown";
        String extension = extractExtension(Objects.requireNonNull(file.getOriginalFilename()));
        String contentType = file.getContentType() != null ? file.getContentType() : "application/octet-stream";

        String objectPath = String.format("%s/%d/%s.%s",
                basePath,
                id,
                uuid,
                extension);
        uploadToMinio(objectPath, file, contentType);
        log.info("Uploaded file to MinIO: {}", objectPath);

        Files entity = new Files()
                .setUuid(uuid)
                .setPath(objectPath)
                .setFileName(originalName)
                .setFileType(contentType);

        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteFile(Long id){
        Files file = findFileOrThrow(id);
        deleteFromMinio(file.getPath());
        repository.delete(file);
    }

    @Override
    @Transactional
    public void deleteFilesByIds(List<Long> ids){
        for(Long id : ids){
            deleteFile(id);
        }
    }

    @Override
    @Transactional
    public List<Files> saveFiles(List<MultipartFile> files, String basePath, Long id) {
        List<Files> filesList = new ArrayList<>();
        for(MultipartFile file : files){
            filesList.add(saveFile(file, basePath, id));
        }
        return filesList;
    }

    // ------------------------------------------------------------------ //
    //  Private helpers
    // ------------------------------------------------------------------ //

    private Files findFileOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new FileNotFoundException(id));
    }

    private byte[] downloadFromMinio(String objectPath) {
        try (InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(minioProperties.getBucketName())
                        .object(objectPath)
                        .build())) {

            return stream.readAllBytes();
        } catch (Exception e) {
            throw new MinioOperationException("GET", objectPath, e);
        }
    }

    private void uploadToMinio(String objectPath, MultipartFile file, String contentType) {
        try (InputStream inputStream = file.getInputStream()) {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(minioProperties.getBucketName())
                            .object(objectPath)
                            .stream(inputStream, file.getSize(), -1)
                            .contentType(contentType)
                            .build());
        } catch (Exception e) {
            throw new MinioOperationException("PUT", objectPath, e);
        }
    }

    private void deleteFromMinio(String objectPath) {
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(minioProperties.getBucketName())
                            .object(objectPath)
                            .build());
        } catch (Exception e) {
            throw new MinioOperationException("DELETE", objectPath, e);
        }
    }

    /** Extracts the file extension, falling back to "bin" if none is found. */
    private String extractExtension(String fileName) {
        int dot = fileName.lastIndexOf('.');
        return (dot != -1 && dot < fileName.length() - 1)
                ? fileName.substring(dot + 1).toLowerCase()
                : "bin";
    }

    /** Removes characters that are unsafe in a MinIO object path segment. */
    private String sanitizePathSegment(String segment) {
        return segment.replaceAll("[^a-zA-Z0-9_\\-]", "_");
    }
}
