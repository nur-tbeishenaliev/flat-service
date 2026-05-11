package kg.build.flat_service.dto.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import kg.build.flat_service.dto.dictionary.DictionaryDto;
import kg.build.flat_service.enums.DictionaryType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Map<String, List<DictionaryDto>> dictionaryValues = new HashMap<>(); // dictionary value key=enumValue, value=title

    @JsonIgnore
    private List<Long> locationIds = new ArrayList<>();

    @Pattern(regexp = "price|createdAt")
    private String sortBy = "price";

    @Pattern(regexp = "asc|desc")
    private String sortDir = "desc";

    @Min(0) private int page = 0;
    @Min(1) @Max(100) private int size = 20;

    public List<Long> getRegionsIds(){
        return dictionaryValues.get(DictionaryType.REGION.name()).stream()
                .map(DictionaryDto::getId)
                .toList();
    }

    public List<Long> getDistrictIds(){
        return dictionaryValues.get(DictionaryType.DISTRICT.name()).stream()
                .map(DictionaryDto::getId)
                .toList();
    }

    public List<Long> getSeriesIds(){
        return dictionaryValues.get(DictionaryType.SERIES.name()).stream()
                .map(DictionaryDto::getId)
                .toList();
    }

    public List<Long> getStateIds(){
        return dictionaryValues.get(DictionaryType.STATE.name()).stream()
                .map(DictionaryDto::getId)
                .toList();
    }
}
