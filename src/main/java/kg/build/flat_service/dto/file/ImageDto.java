package kg.build.flat_service.dto.file;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ImageDto {
    private Long id;
    private String fileName;
}
