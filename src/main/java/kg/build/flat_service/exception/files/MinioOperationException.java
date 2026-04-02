package kg.build.flat_service.exception.files;

public class MinioOperationException extends RuntimeException {
    public MinioOperationException(String operation, String path, Throwable cause) {
        super("MinIO operation [" + operation + "] failed for path '" + path + "': " + cause.getMessage(), cause);
    }
}
