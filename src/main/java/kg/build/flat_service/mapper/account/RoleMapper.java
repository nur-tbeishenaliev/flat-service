package kg.build.flat_service.mapper.account;

import kg.build.flat_service.dto.account.RoleDto;
import kg.build.flat_service.entity.account.Role;

public interface RoleMapper {

    RoleDto toDto(Role role);
}
