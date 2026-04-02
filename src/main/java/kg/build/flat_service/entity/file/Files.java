package kg.build.flat_service.entity.file;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "files")
@Data
@Accessors(chain = true)
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "files_seq")
    @SequenceGenerator(
            name = "files_seq",
            sequenceName = "files_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String fileType;

}
