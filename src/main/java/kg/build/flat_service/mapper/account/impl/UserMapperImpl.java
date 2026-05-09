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

import java.util.Objects;
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

    public void copyUserInfo(User existUser, User newData){
        existUser.setUsername(Objects.nonNull(newData.getUsername()) ?
                newData.getUsername() : existUser.getUsername());

        existUser.setPassword(Objects.nonNull(newData.getPassword()) ?
                newData.getPassword() : existUser.getPassword());

        existUser.setFirstName(Objects.nonNull(newData.getFirstName()) ?
                newData.getFirstName() : existUser.getFirstName());

        existUser.setLastName(Objects.nonNull(newData.getLastName()) ?
                newData.getLastName() : existUser.getLastName());

        existUser.setRole(Objects.nonNull(newData.getRole()) ?
                newData.getRole() : existUser.getRole());

        existUser.setContactInfo(Objects.nonNull(newData.getContactInfo()) ?
                newData.getContactInfo() : existUser.getContactInfo());

        existUser.setIsAccountNonLocked(Objects.nonNull(newData.getIsAccountNonLocked()) ?
                newData.getIsAccountNonLocked() : existUser.getIsAccountNonLocked());
    }
}
