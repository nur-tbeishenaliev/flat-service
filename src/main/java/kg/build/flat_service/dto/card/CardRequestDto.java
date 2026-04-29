package kg.build.flat_service.dto.card;

import kg.build.flat_service.dto.dictionary.DictionaryDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
public class CardRequestDto {
    private String description;
    private Double price;
    private String currencyType;
    private String offerType;
    private Integer floor;
    private String objectSize;
    private Integer amountOfRooms;
    private String address;
    private OwnerInfoDto ownerInfo;
    private String status; // enum value
    private Map<String, DictionaryDto> dictionaryValues;
}
