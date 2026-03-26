package kg.build.flat_service.config.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("FLAT Service API")
                        .description("Api for manage objects between employees")
                        .version("v1.0.0"));
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}