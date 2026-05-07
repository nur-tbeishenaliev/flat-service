package kg.build.flat_service.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SellRequestSearch {
    private String keyWord;
    private String status;

    @Pattern(regexp = "createdAt")
    private String sortBy = "createdAt";

    @Pattern(regexp = "asc|desc")
    private String sortDir = "desc";

    @Min(0) private int page = 0;
    @Min(1) @Max(100) private int size = 20;
}
