package kg.build.flat_service.mapper.card.impl;

import kg.build.flat_service.dto.card.CardDto;
import kg.build.flat_service.dto.card.CardRequestDto;
import kg.build.flat_service.dto.dictionary.DictionaryDto;
import kg.build.flat_service.entity.card.ObjectCard;
import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.enums.CurrencyType;
import kg.build.flat_service.enums.ObjectStatus;
import kg.build.flat_service.enums.OfferType;
import kg.build.flat_service.mapper.account.UserMapper;
import kg.build.flat_service.mapper.card.ObjectCardMapper;
import kg.build.flat_service.mapper.card.OwnerInfoMapper;
import kg.build.flat_service.mapper.dictionary.DictionaryMapper;
import kg.build.flat_service.mapper.file.FileMapper;
import kg.build.flat_service.service.dictionary.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectCardMapperImpl
    implements ObjectCardMapper {

    private final UserMapper userMapper;
    private final FileMapper fileMapper;
    private final OwnerInfoMapper ownerInfoMapper;
    private final DictionaryMapper dictionaryMapper;
    private final DictionaryService dictionaryService;

    @Override
    public CardDto toCardDto(ObjectCard card) {
        if(Objects.isNull(card)){
            return null;
        }

        return new CardDto()
                .setId(card.getId())
                .setCreatedBy(userMapper.toResponseDto(card.getCreatedBy()))
                .setDescription(card.getDescription())
                .setPrice(card.getPrice() != null ?
                        card.getPrice().doubleValue() : 0.0)
                .setCurrencyType(card.getCurrencyType() != null ?
                        card.getCurrencyType().getValue() : CurrencyType.DOLLAR.getValue())
                .setOfferType(card.getOfferType() != null ?
                        card.getOfferType().getDescription() : null)
                .setFloor(card.getFloor())
                .setObjectSize(card.getObjectSize())
                .setAmountOfRooms(card.getAmountOfRooms())
                .setUtilities(card.getUtilities())
                .setAddress(card.getAddress())
                .setImages(card.getImages().stream()
                        .map(fileMapper::toDto)
                        .toList())
                .setOwnerInfo(ownerInfoMapper.toDto(card.getOwnerInfo()))
                .setUpdatedAt(card.getUpdatedAt())
                .setCreatedAt(card.getCreatedAt())
                .setStatus(card.getStatus() != null ?
                        card.getStatus().getName() : null)
                .setDictionaryValues(card.getDictionaries().stream()
                        .collect(Collectors.toMap(
                                d -> d.getType().getName(),
                                dictionaryMapper::toDto)));
    }

    @Override
    public ObjectCard toObjectCard(CardRequestDto cardRequestDto) {
        if(Objects.isNull(cardRequestDto)){
            return null;
        }

        List<Long> dictionaryIds = cardRequestDto.getDictionaryValues()
                .values()
                .stream()
                .map(DictionaryDto::getId)
                .toList();

        Set<Dictionary> dictionaries = dictionaryService.getDictionariesByIds(dictionaryIds);

        return new ObjectCard()
                .setDescription(cardRequestDto.getDescription())
                .setPrice(BigDecimal.valueOf(cardRequestDto.getPrice()))
                .setCurrencyType(CurrencyType.valueOf(cardRequestDto.getCurrencyType()))
                .setOfferType(OfferType.valueOf(cardRequestDto.getOfferType()))
                .setFloor(cardRequestDto.getFloor())
                .setObjectSize(cardRequestDto.getObjectSize())
                .setAmountOfRooms(cardRequestDto.getAmountOfRooms())
                .setAddress(cardRequestDto.getAddress())
                .setOwnerInfo(ownerInfoMapper.toEntity(cardRequestDto.getOwnerInfo()))
                .setStatus(ObjectStatus.valueOf(cardRequestDto.getStatus()))
                .setDictionaries(dictionaries);
    }
}
