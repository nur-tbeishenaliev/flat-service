package kg.build.flat_service.mapper.card;

import kg.build.flat_service.dto.card.OwnerInfoDto;
import kg.build.flat_service.entity.card.OwnerInfo;

public interface OwnerInfoMapper {

    OwnerInfoDto toDto(OwnerInfo ownerInfo);

    OwnerInfo toEntity(OwnerInfoDto ownerInfoDto);

}
