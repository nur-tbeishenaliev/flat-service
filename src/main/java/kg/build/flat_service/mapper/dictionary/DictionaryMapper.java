package kg.build.flat_service.mapper.dictionary;

import kg.build.flat_service.dto.dictionary.DictionaryDto;
import kg.build.flat_service.entity.dictionary.Dictionary;

public interface DictionaryMapper {

    DictionaryDto toDto(Dictionary dictionary);

}
