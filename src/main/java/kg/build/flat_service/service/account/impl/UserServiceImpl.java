package kg.build.flat_service.service.account.impl;

import kg.build.flat_service.dto.account.UserFilter;
import kg.build.flat_service.dto.account.UserRequestDto;
import kg.build.flat_service.dto.account.UserResponseDto;
import kg.build.flat_service.entity.account.User;
import kg.build.flat_service.mapper.account.UserMapper;
import kg.build.flat_service.repository.account.UserRepository;
import kg.build.flat_service.repository.account.specification.UserSpecification;
import kg.build.flat_service.service.account.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<UserResponseDto> getUsers(UserFilter filter){

        Sort sort = filter.getSortOrder().equalsIgnoreCase("desc")
                ? Sort.by(filter.getSortBy()).descending()
                : Sort.by(filter.getSortBy()).ascending();

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
        userRepository.save(userMapper.toEntity(user));
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
    public UserResponseDto registerUser(UserRequestDto userRequestDto){
        userRequestDto.setIsAccountNonLocked(false);
        return userMapper.toResponseDto(
                userRepository.save(userMapper.toEntity(userRequestDto)));
    }
}
