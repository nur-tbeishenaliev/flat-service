package kg.build.flat_service.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kg.build.flat_service.exception.validation.UsernameAlreadyExistsException;
import kg.build.flat_service.repository.account.UserRepository;
import kg.build.flat_service.validation.annotations.UniqueUsername;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UniqueUsernameValidator
implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @SneakyThrows
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(Objects.isNull(username) || username.isBlank()){
            return false;
        }

        if (userRepository.existsByUsername(username)) {
            context.disableDefaultConstraintViolation();
            throw new UsernameAlreadyExistsException(username);
        }

        return true;
    }
}
