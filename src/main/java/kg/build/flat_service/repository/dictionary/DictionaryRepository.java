package kg.build.flat_service.repository.dictionary;

import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.enums.DictionaryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    List<Dictionary> findByType(DictionaryType type);
    Set<Dictionary> findByIdIn(List<Long> ids);
}
