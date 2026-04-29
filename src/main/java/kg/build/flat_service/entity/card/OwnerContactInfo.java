package kg.build.flat_service.entity.card;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "owner_contact_info")
@Data
@Accessors(chain = true)
public class OwnerContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "owner_contact_info_seq")
    @SequenceGenerator(name = "owner_contact_info_seq",
    sequenceName = "owner_contact_info_seq",
    allocationSize = 1)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "other")
    private String other;
}
