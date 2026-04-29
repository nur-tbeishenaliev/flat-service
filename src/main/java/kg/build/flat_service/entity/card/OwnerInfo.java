package kg.build.flat_service.entity.card;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "owner_info")
@Data
@Accessors(chain = true)
public class OwnerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "owner_info_seq")
    @SequenceGenerator(
            name = "owner_info_seq",
            sequenceName = "owner_info_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "contact_info_id")
    private OwnerContactInfo contactInfo;
}
