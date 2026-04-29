package kg.build.flat_service.dto.card;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import kg.build.flat_service.dto.dictionary.DictionaryDto;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Map;

@Data
@Accessors(chain = true)
public class CardSearchRequest {
    private String keyWord;
    private Integer roomAmount;
    private String currencyType;
    private String status;
    private Double maxPrice;
    private Double minPrice;
    private Map<String, DictionaryDto> dictionaryValues; // dictionary value key=enumValue, value=title

    @Pattern(regexp = "price|createdAt")
    private String sortBy = "price";

    @Pattern(regexp = "asc|desc")
    private String sortDir = "desc";

    @Min(0) private int page = 0;
    @Min(1) @Max(100) private int size = 20;
}
