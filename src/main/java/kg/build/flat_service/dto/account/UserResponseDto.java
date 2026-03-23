package kg.build.flat_service.dto.account;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserResponseDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String roleDescription;
    private ContactInfoDto contactInfo;
    private Boolean isAccountNonLocked;
}
