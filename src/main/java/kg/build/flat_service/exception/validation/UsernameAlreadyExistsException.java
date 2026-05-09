package kg.build.flat_service.exception.validation;

public class UsernameAlreadyExistsException extends Exception {

    public UsernameAlreadyExistsException(String username) {
        super(String.format("Пользователь с таким именем уже существует %s.", username));
    }

}
