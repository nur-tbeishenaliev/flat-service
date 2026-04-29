package kg.build.flat_service.dto.dictionary;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DictionaryDto {
    private Long id;
    private String name;
}
