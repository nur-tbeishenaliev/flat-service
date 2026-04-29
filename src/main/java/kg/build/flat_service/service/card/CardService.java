package kg.build.flat_service.service.card;

import kg.build.flat_service.dto.card.CardDto;
import kg.build.flat_service.dto.card.CardRequestDto;
import kg.build.flat_service.dto.card.CardSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CardService {

    CardDto getById(Long id);

    void saveCard(CardRequestDto dto, List<MultipartFile> images);

    void updateCard(Long cardId, CardRequestDto dto);

    void addImage(Long cardId, MultipartFile file);

    void deleteCard(Long cardId);

    Page<CardDto> searchCards(CardSearchRequest searchRequest);
}
