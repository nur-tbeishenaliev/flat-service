package kg.build.flat_service.mapper.dictionary.impl;

import kg.build.flat_service.dto.dictionary.DictionaryDto;
import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.mapper.dictionary.DictionaryMapper;
import org.springframework.stereotype.Service;

@Service
public class DictionaryMapperImpl
        implements DictionaryMapper {

    @Override
    public DictionaryDto toDto(Dictionary dictionary) {
        return new DictionaryDto()
                .setId(dictionary.getId())
                .setName(dictionary.getName());
    }
}
