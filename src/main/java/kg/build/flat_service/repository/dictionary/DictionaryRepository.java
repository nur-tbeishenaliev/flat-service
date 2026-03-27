package kg.build.flat_service.repository.dictionary;

import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.enums.DictionaryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    List<Dictionary> findByType(DictionaryType type);
}
