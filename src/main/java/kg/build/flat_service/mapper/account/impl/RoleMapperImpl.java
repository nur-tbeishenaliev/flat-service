package kg.build.flat_service.mapper.account.impl;

import kg.build.flat_service.dto.account.RoleDto;
import kg.build.flat_service.entity.account.Role;
import kg.build.flat_service.mapper.account.RoleMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleMapperImpl implements RoleMapper {

    public RoleDto toDto(Role role){
        return new RoleDto()
                .setId(role.getId())
                .setDescription(role.getDescription());
    }
}
