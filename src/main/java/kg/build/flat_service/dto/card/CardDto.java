package kg.build.flat_service.dto.card;

import kg.build.flat_service.dto.account.UserResponseDto;
import kg.build.flat_service.dto.dictionary.DictionaryDto;
import kg.build.flat_service.dto.file.ImageDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class CardDto {
    private Long id;
    private UserResponseDto createdBy;
    private String description;
    private Double price;
    private String currencyType;
    private String offerType;
    private Integer floor;
    private String objectSize;
    private Integer amountOfRooms;
    private String utilities;
    private String address;
    private List<ImageDto> images;
    private OwnerInfoDto ownerInfo;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String status;
    private Map<String, DictionaryDto> dictionaryValues;
}
