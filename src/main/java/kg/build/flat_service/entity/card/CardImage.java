package kg.build.flat_service.entity.card;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "car_image")
@Data
@Accessors(chain = true)
public class CardImage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "car_image_seq")
    @SequenceGenerator(
            name = "car_image_seq",
            sequenceName = "car_image_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private ObjectCard card;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "path")
    private String path;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "extension")
    private String extension;
}
