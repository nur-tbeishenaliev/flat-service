package kg.build.flat_service.entity.account;

import jakarta.persistence.*;
import kg.build.flat_service.enums.PermissionCode;
import lombok.Data;

@Entity
@Table(name = "permissions")
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_seq")
    @SequenceGenerator(
            name = "permissions_seq",
            sequenceName = "permissions_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "permission_code",
            nullable = false,
            unique = true)
    private PermissionCode permissionCode;

    @Column(name = "description")
    private String description;
}
