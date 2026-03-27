package kg.build.flat_service.service.dictionary.impl;

import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.enums.DictionaryType;
import kg.build.flat_service.repository.dictionary.DictionaryRepository;
import kg.build.flat_service.service.dictionary.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    @Override
    public List<Dictionary> getDictionaryByType(DictionaryType type){
        return dictionaryRepository.findByType(type);
    }
}
