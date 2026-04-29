package kg.build.flat_service.dto.card;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OwnerContactInfoDto {
    private Long id;
    private String phoneNumber;
    private String email;
    private String other;
}
