package kg.build.flat_service.mapper.card;

import kg.build.flat_service.dto.card.OwnerContactInfoDto;
import kg.build.flat_service.entity.card.OwnerContactInfo;

public interface OwnerContactInfoMapper {

    OwnerContactInfoDto toDto(OwnerContactInfo contactInfo);

    OwnerContactInfo toEntity(OwnerContactInfoDto ownerContactInfoDto);

}
