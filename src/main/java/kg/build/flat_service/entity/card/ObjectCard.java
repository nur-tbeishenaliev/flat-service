package kg.build.flat_service.entity.card;

import jakarta.persistence.*;
import kg.build.flat_service.entity.account.ContactInfo;
import kg.build.flat_service.entity.account.User;
import kg.build.flat_service.enums.CurrencyType;
import kg.build.flat_service.enums.ObjectStatus;
import kg.build.flat_service.enums.OfferType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "active_card")
@Data
@Accessors(chain = true)
public class ObjectCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "active_card_seq")
    @SequenceGenerator(
            name = "active_card_seq",
            sequenceName = "active_card_seq",
            allocationSize = 1
    )
    private Long id;

    @OneToOne
    @JoinColumn(name = "contact_info")
    private ContactInfo contactInfo;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type")
    private CurrencyType currencyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "offer_type")
    private OfferType offerType;

    @Column(name = "object_type")
    private String objectType;

    @Column(name = "floor")
    private String floor;

    @Column(name = "object_size")
    private String objectSize;

    @Column(name = "amount_of_rooms")
    private Integer amountOfRooms;

    @Column(name = "condition")
    private String condition;

    @Column(name = "utilities")
    private String utilities;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @OneToMany
    private List<CardImage> images;

    @OneToOne
    @JoinColumn(name = "owner_info_id")
    private OwnerInfo ownerInfo;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ObjectStatus status;
}
