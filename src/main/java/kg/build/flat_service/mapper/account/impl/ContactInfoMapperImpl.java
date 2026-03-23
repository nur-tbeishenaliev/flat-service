package kg.build.flat_service.mapper.account.impl;

import kg.build.flat_service.dto.account.ContactInfoDto;
import kg.build.flat_service.entity.account.ContactInfo;
import kg.build.flat_service.mapper.account.ContactInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoMapperImpl implements ContactInfoMapper {

    @Override
    public ContactInfo toEntity(ContactInfoDto dto) {
        return new ContactInfo()
                .setId(dto.getId())
                .setPhoneNumber(dto.getPhoneNumber())
                .setEmail(dto.getEmail())
                .setOther(dto.getOther());
    }

    @Override
    public ContactInfoDto toDto(ContactInfo entity) {
        return new ContactInfoDto()
                .setId(entity.getId())
                .setPhoneNumber(entity.getPhoneNumber())
                .setEmail(entity.getEmail())
                .setOther(entity.getOther());
    }
}
