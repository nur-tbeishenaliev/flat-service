package kg.build.flat_service.controller.account;

import kg.build.flat_service.dto.account.RoleDto;
import kg.build.flat_service.service.account.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    List<RoleDto> getAllRoles(){
        return roleService.getAll();
    }

}
