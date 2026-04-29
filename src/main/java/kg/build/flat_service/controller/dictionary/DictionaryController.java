package kg.build.flat_service.controller.dictionary;

import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.enums.DictionaryType;
import kg.build.flat_service.service.dictionary.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @GetMapping("/regions")
    public List<Dictionary> getRegions(){
        return dictionaryService.getDictionaryByType(DictionaryType.REGION);
    }

    @GetMapping("/series")
    public List<Dictionary> getSeries(){
        return dictionaryService.getDictionaryByType(DictionaryType.SERIES);
    }

    @GetMapping("/states")
    public List<Dictionary> getState(){
        return dictionaryService.getDictionaryByType(DictionaryType.STATE);
    }
}
