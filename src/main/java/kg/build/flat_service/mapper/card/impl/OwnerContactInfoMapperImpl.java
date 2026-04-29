package kg.build.flat_service.mapper.card.impl;

import kg.build.flat_service.dto.card.OwnerContactInfoDto;
import kg.build.flat_service.entity.card.OwnerContactInfo;
import kg.build.flat_service.mapper.card.OwnerContactInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerContactInfoMapperImpl
        implements OwnerContactInfoMapper {

    @Override
    public OwnerContactInfoDto toDto(OwnerContactInfo contactInfo) {
        return new OwnerContactInfoDto()
                .setId(contactInfo.getId())
                .setPhoneNumber(contactInfo.getPhoneNumber())
                .setEmail(contactInfo.getEmail())
                .setOther(contactInfo.getOther());
    }

    @Override
    public OwnerContactInfo toEntity(OwnerContactInfoDto ownerContactInfoDto) {
        return new OwnerContactInfo()
                .setId(ownerContactInfoDto.getId())
                .setPhoneNumber(ownerContactInfoDto.getPhoneNumber())
                .setEmail(ownerContactInfoDto.getEmail())
                .setOther(ownerContactInfoDto.getOther());
    }

}
