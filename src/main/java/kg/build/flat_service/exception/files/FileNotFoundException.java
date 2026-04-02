package kg.build.flat_service.exception.files;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(Long id) {
        super("File record not found in database for id: " + id);
    }
}
