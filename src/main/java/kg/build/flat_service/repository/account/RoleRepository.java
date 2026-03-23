package kg.build.flat_service.repository.account;

import kg.build.flat_service.entity.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
