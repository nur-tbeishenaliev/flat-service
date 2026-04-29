package kg.build.flat_service.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kg.build.flat_service.dto.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper;

    public CustomAuthenticationFailureHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException ex) throws IOException {

        log.warn("Auth failure on [{}]: {}", request.getRequestURI(), ex.getClass().getSimpleName());

        String message = switch (ex) {
            case LockedException e         -> "Пользователь заблокирован обратитесь к админу";
            case DisabledException e       -> "Пользователь отключён";
            case BadCredentialsException e -> "Неверный логин или пароль";
            default                        -> "Ошибка аутентификации";
        };

        int status = ex instanceof LockedException
                ? HttpStatus.FORBIDDEN.value()
                : HttpStatus.UNAUTHORIZED.value();

        ErrorResponse body = ErrorResponse.of(
                status,
                HttpStatus.valueOf(status).getReasonPhrase(),
                message,
                request.getRequestURI()
        );

        response.setStatus(status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(response.getWriter(), body);
    }
}