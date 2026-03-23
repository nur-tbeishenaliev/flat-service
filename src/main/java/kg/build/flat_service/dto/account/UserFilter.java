package kg.build.flat_service.dto.account;

import lombok.Data;

@Data
public class UserFilter {
    private String username;

    private int page = 0;
    private int pageSize = 5;
    private String sortBy = "id";
    private String sortOrder = "asc";
}
