package kg.build.flat_service.service.account;

import kg.build.flat_service.dto.account.UserFilter;
import kg.build.flat_service.dto.account.UserRequestDto;
import kg.build.flat_service.dto.account.UserResponseDto;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<UserResponseDto> getUsers(UserFilter filter);

    UserResponseDto findById(Long id);

    void createOrUpdate(UserRequestDto user);

    void deleteById(Long id);

    void unlockUser(Long id);

    void blockUser(Long id);

    UserResponseDto registerUser(UserRequestDto userRequestDto);
}
