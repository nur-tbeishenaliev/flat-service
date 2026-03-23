package kg.build.flat_service.dto.account;

import lombok.Data;

@Data
public class UserRequestDto {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Long roleId;
    private ContactInfoDto contactInfo;
    private Boolean isAccountNonLocked;
}
