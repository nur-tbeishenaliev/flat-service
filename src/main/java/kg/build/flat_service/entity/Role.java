package kg.build.flat_service.entity;

import jakarta.persistence.*;
import kg.build.flat_service.enums.RoleCode;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @SequenceGenerator(
            name = "roles_seq",
            sequenceName = "roles_seq",
            allocationSize = 1
    )
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_code", nullable = false, unique = true)
    private RoleCode roleCode;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<Permission> permissions;
}
