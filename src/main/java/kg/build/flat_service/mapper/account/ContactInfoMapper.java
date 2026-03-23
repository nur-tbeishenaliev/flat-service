package kg.build.flat_service.mapper.account;

import kg.build.flat_service.dto.account.ContactInfoDto;
import kg.build.flat_service.entity.account.ContactInfo;

public interface ContactInfoMapper {

    ContactInfo toEntity(ContactInfoDto dto);

    ContactInfoDto toDto(ContactInfo entity);
}
