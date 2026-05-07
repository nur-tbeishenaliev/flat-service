package kg.build.flat_service.dto.requests;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SellRequestCreateDto {
    private Long id;
    private String description;
    private String status;
    private Long userForProcess;
}
