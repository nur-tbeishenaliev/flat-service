package kg.build.flat_service.repository.account;

import kg.build.flat_service.entity.account.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
