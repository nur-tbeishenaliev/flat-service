package kg.build.flat_service.dto.account;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserFilter {
    private String username;

    private int page = 0;
    private int pageSize = 5;

    @Pattern(regexp = "id")
    private String sortBy = "id";

    @Pattern(regexp = "asc|desc")
    private String sortOrder = "asc";
}
