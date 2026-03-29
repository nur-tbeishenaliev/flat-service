package kg.build.flat_service.entity.dictionary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.build.flat_service.enums.DictionaryType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dictionary")
@Data
@Accessors(chain = true)
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "dictionary_seq")
    @SequenceGenerator(
            name = "dictionary_seq",
            sequenceName = "dictionary_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    private DictionaryType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Dictionary parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Dictionary> children = new ArrayList<>();
}
