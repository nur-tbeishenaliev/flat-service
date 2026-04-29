package kg.build.flat_service.entity.card;

import jakarta.persistence.*;
import kg.build.flat_service.entity.account.User;
import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.entity.file.Files;
import kg.build.flat_service.enums.CurrencyType;
import kg.build.flat_service.enums.ObjectStatus;
import kg.build.flat_service.enums.OfferType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @Column(name = "description")
    private String description;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type")
    private CurrencyType currencyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "offer_type")
    private OfferType offerType;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "object_size")
    private String objectSize;

    @Column(name = "amount_of_rooms")
    private Integer amountOfRooms;

    @Column(name = "utilities")
    private String utilities;

    @Column(name = "address")
    private String address;

    @OneToMany
    @JoinTable(
            name = "card_images",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private List<Files> images;

    public List<Files> getImages() {
        if(Objects.isNull(images)){
            return new ArrayList<Files>();
        }
        return images;
    }

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "active_card_dictionaries",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "dictionary_id")
    )
    private Set<Dictionary> dictionaries;
}
