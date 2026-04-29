package kg.build.flat_service.mapper.card;

import kg.build.flat_service.dto.card.CardDto;
import kg.build.flat_service.dto.card.CardRequestDto;
import kg.build.flat_service.entity.card.ObjectCard;


public interface ObjectCardMapper {

    CardDto toCardDto(ObjectCard card);

    ObjectCard toObjectCard(CardRequestDto cardRequestDto);

}
