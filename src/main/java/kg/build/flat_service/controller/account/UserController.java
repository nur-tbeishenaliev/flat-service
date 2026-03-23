package kg.build.flat_service.controller.account;

import kg.build.flat_service.dto.account.UserFilter;
import kg.build.flat_service.dto.account.UserRequestDto;
import kg.build.flat_service.dto.account.UserResponseDto;
import kg.build.flat_service.service.account.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/search")
    public Page<UserResponseDto> getUsers(@RequestBody UserFilter filter) {
        return userService.getUsers(filter);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public void createOrUpdate(@RequestBody UserRequestDto dto){
        userService.createOrUpdate(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/unlock")
    public void unlockUser(@RequestParam Long id){
        userService.unlockUser(id);
    }

    @GetMapping("/block")
    public void block(@RequestParam Long id){
        userService.blockUser(id);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.registerUser(userRequestDto),
                HttpStatusCode.valueOf(200));
    }

}
