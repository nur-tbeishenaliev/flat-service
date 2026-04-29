package kg.build.flat_service.controller.card;

import jakarta.validation.Valid;
import kg.build.flat_service.dto.card.CardDto;
import kg.build.flat_service.dto.card.CardRequestDto;
import kg.build.flat_service.dto.card.CardSearchRequest;
import kg.build.flat_service.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public CardDto getById(@PathVariable("id") Long id){
        return cardService.getById(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createCard(
            @RequestPart("cardRequest") CardRequestDto dto,
            @RequestPart("images") List<MultipartFile> images) {
        cardService.saveCard(dto,images);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCard(@PathVariable("id") Long cardId,
                                           @RequestBody @Valid CardRequestDto dto){
        cardService.updateCard(cardId,dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{id}/image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> addImage(@PathVariable("id") Long id,
                                         @RequestPart MultipartFile file){
        cardService.addImage(id,file);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCard(@PathVariable("id") Long cardId){
        cardService.deleteCard(cardId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<Page<CardDto>> searchCard(
            @RequestBody @Valid CardSearchRequest searchRequest){
        return ResponseEntity.ok(cardService.searchCards(searchRequest));
    }
}
