package kg.build.flat_service.service.account.impl;

import kg.build.flat_service.dto.account.UserFilter;
import kg.build.flat_service.dto.account.UserRequestDto;
import kg.build.flat_service.dto.account.UserResponseDto;
import kg.build.flat_service.entity.account.User;
import kg.build.flat_service.mapper.account.UserMapper;
import kg.build.flat_service.repository.account.ContactInfoRepository;
import kg.build.flat_service.repository.account.UserRepository;
import kg.build.flat_service.repository.account.specification.UserSpecification;
import kg.build.flat_service.service.account.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ContactInfoRepository contactInfoRepository;
    private final UserMapper userMapper;

    @Override
    public Page<UserResponseDto> getUsers(UserFilter filter){

        Sort sort = Sort.by(
                "desc".equals(filter.getSortOrder()) ? Sort.Direction.DESC : Sort.Direction.ASC,
                filter.getSortBy()
        );

        Pageable pageable = PageRequest.of(filter.getPage(), filter.getPageSize(), sort);

        return userRepository.findAll(UserSpecification.build(filter), pageable)
                .map(userMapper::toResponseDto);
    }

    @Override
    public UserResponseDto findById(Long id){
        return userRepository.findById(id)
                .map(userMapper::toResponseDto)
                .orElse(null);
    }

    @Override
    public void createOrUpdate(UserRequestDto user){
        User userForSave = userMapper.toEntity(user);

        // save sub entities if transient
        if(Objects.nonNull(userForSave.getContactInfo()) &&
        Objects.isNull(userForSave.getContactInfo().getId())){
            contactInfoRepository.save(userForSave.getContactInfo());
        }

        // update if user exist
        if(Objects.nonNull(userForSave.getId())){
            User existUser = userRepository.findById(user.getId()).orElseThrow();
            userMapper.copyUserInfo(existUser,userForSave);
            userRepository.save(existUser);
            return;
        }
        userRepository.save(userForSave);
    }

    @Override
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public void unlockUser(Long id){
        User user = userRepository.getReferenceById(id);
        user.setIsAccountNonLocked(true);
        userRepository.save(user);
    }

    @Override
    public void blockUser(Long id){
        User user = userRepository.getReferenceById(id);
        user.setIsAccountNonLocked(false);
        userRepository.save(user);
    }

    @Override
    public UserResponseDto registerUser(UserRequestDto userDto){
        User userForSave = userMapper.toEntity(userDto);
        userForSave.setIsAccountNonLocked(false);

        if(Objects.nonNull(userForSave.getContactInfo())){
            contactInfoRepository.save(userForSave.getContactInfo());
        }

        return userMapper.toResponseDto(
                userRepository.save(userForSave));
    }
}
