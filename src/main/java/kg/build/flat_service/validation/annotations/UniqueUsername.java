package kg.build.flat_service.validation.annotations;

import java.lang.annotation.*;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import kg.build.flat_service.validation.validators.UniqueUsernameValidator;

@Documented
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "Пользователь с таким логином уже есть!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
