package kg.build.flat_service.service.dictionary;

import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.enums.DictionaryType;

import java.util.List;
import java.util.Set;

public interface DictionaryService {

    List<Dictionary> getDictionaryByType(DictionaryType type);

    Set<Dictionary> getDictionariesByIds(List<Long> ids);
}
