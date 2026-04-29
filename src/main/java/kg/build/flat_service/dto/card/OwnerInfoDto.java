package kg.build.flat_service.dto.card;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OwnerInfoDto {
    private Long id;
    private String firstName;
    private String lastName;
    private OwnerContactInfoDto contactInfo;
}
