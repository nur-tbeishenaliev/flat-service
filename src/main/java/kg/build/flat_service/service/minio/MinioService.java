package kg.build.flat_service.service.minio;

import kg.build.flat_service.entity.file.Files;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MinioService {

    byte[] getFileById(Long id);

    List<byte[]> getFileByIds(List<Long> ids);

    Files saveFile(MultipartFile file,String basePath, Long id);

    void deleteFile(Long id);

    void deleteFilesByIds(List<Long> ids);

    List<Files> saveFiles(List<MultipartFile> files, String basePath, Long id);
}
