package kg.build.flat_service.controller.file;

import kg.build.flat_service.service.minio.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final MinioService minioService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        byte[] data = minioService.getFileById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(data);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<byte[]>> getFiles(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(minioService.getFileByIds(ids));
    }

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Files> uploadFile(@RequestParam("file") MultipartFile file) {
//        Files saved = minioService.saveFile(file);
//        return ResponseEntity.ok(saved);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long id) {
        minioService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }
}
