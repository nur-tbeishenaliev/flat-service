package kg.build.flat_service.entity.account;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "contact_info")
@Data
@Accessors(chain = true)
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_info_seq")
    @SequenceGenerator(
            name = "contact_info_seq",
            sequenceName = "contact_info_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "other")
    private String other;
}
