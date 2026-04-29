package kg.build.flat_service.mapper.card.impl;

import kg.build.flat_service.dto.card.OwnerInfoDto;
import kg.build.flat_service.entity.card.OwnerInfo;
import kg.build.flat_service.mapper.card.OwnerContactInfoMapper;
import kg.build.flat_service.mapper.card.OwnerInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerInfoMapperImpl
        implements OwnerInfoMapper {

    private final OwnerContactInfoMapper ownerContactInfoMapper;

    @Override
    public OwnerInfoDto toDto(OwnerInfo ownerInfo) {
        return new OwnerInfoDto()
                .setId(ownerInfo.getId())
                .setFirstName(ownerInfo.getFirstName())
                .setLastName(ownerInfo.getLastName())
                .setContactInfo(ownerContactInfoMapper.toDto(ownerInfo.getContactInfo()));
    }

    @Override
    public OwnerInfo toEntity(OwnerInfoDto ownerInfoDto) {
        return new OwnerInfo()
                .setId(ownerInfoDto.getId())
                .setFirstName(ownerInfoDto.getFirstName())
                .setLastName(ownerInfoDto.getLastName())
                .setContactInfo(ownerContactInfoMapper.toEntity(ownerInfoDto.getContactInfo()));
    }
}
