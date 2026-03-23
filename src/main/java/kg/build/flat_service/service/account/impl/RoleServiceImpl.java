package kg.build.flat_service.service.account.impl;

import kg.build.flat_service.dto.account.RoleDto;
import kg.build.flat_service.mapper.account.RoleMapper;
import kg.build.flat_service.repository.account.RoleRepository;
import kg.build.flat_service.service.account.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDto> getAll(){
        return roleRepository.findAll().stream()
                .map(roleMapper::toDto)
                .toList();
    }
}
