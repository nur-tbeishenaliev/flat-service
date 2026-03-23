package kg.build.flat_service.dto.account;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoleDto {
    private Long id;
    private String description;
}
