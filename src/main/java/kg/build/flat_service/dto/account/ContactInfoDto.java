package kg.build.flat_service.dto.account;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ContactInfoDto {
    Long id;
    String phoneNumber;
    String email;
    String other;
}
