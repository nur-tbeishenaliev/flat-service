package kg.build.flat_service.config.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class MinioConfig {

    private final MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient(){
       MinioClient client = MinioClient.builder()
               .endpoint(minioProperties.getUrl())
               .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
               .build();

       ensureBucketExists(client);
       return client;
    }

    /**
     * Creates the bucket on startup if it doesn't already exist.
     */
    private void ensureBucketExists(MinioClient client) {
        try {
            boolean exists = client.bucketExists(
                    BucketExistsArgs.builder()
                            .bucket(minioProperties.getBucketName())
                            .build()
            );
            if (!exists) {
                client.makeBucket(
                        MakeBucketArgs.builder()
                                .bucket(minioProperties.getBucketName())
                                .build()
                );
                log.info("MinIO bucket '{}' created.", minioProperties.getBucketName());
            } else {
                log.info("MinIO bucket '{}' already exists.", minioProperties.getBucketName());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize MinIO bucket: " + e.getMessage(), e);
        }
    }

}
