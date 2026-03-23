package kg.build.flat_service.mapper.account.impl;

import kg.build.flat_service.dto.account.UserRequestDto;
import kg.build.flat_service.dto.account.UserResponseDto;
import kg.build.flat_service.entity.account.Role;
import kg.build.flat_service.entity.account.User;
import kg.build.flat_service.mapper.account.ContactInfoMapper;
import kg.build.flat_service.mapper.account.UserMapper;
import kg.build.flat_service.repository.account.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final ContactInfoMapper contactInfoMapper;

    public User toEntity(UserRequestDto userRequestDto){
        Optional<Role> role = roleRepository.findById(userRequestDto.getRoleId());
        if(role.isEmpty()){
            throw new IllegalArgumentException("Заданное имя роли не найдено");
        }

        return new User()
                .setId(userRequestDto.getId())
                .setUsername(userRequestDto.getUsername())
                .setPassword(passwordEncoder.encode(userRequestDto.getPassword()))
                .setFirstName(userRequestDto.getFirstName())
                .setLastName(userRequestDto.getLastName())
                .setRole(role.get())
                .setContactInfo(contactInfoMapper.toEntity(userRequestDto.getContactInfo()))
                .setIsAccountNonLocked(userRequestDto.getIsAccountNonLocked());
    }

    public UserResponseDto toResponseDto(User user){
        return new UserResponseDto()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setRoleDescription(user.getRole().getDescription())
                .setContactInfo(contactInfoMapper.toDto(user.getContactInfo()))
                .setIsAccountNonLocked(user.getIsAccountNonLocked());
    }
}
