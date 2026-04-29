package kg.build.flat_service.service.card.impl;

import jakarta.transaction.Transactional;
import kg.build.flat_service.dto.card.CardDto;
import kg.build.flat_service.dto.card.CardRequestDto;
import kg.build.flat_service.dto.card.CardSearchRequest;
import kg.build.flat_service.entity.card.ObjectCard;
import kg.build.flat_service.entity.file.Files;
import kg.build.flat_service.mapper.card.ObjectCardMapper;
import kg.build.flat_service.repository.card.ObjectCardRepository;
import kg.build.flat_service.repository.card.specification.CardObjectSpecification;
import kg.build.flat_service.service.card.CardService;
import kg.build.flat_service.service.minio.MinioService;
import kg.build.flat_service.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final ObjectCardRepository objectCardRepository;
    private final ObjectCardMapper objectCardMapper;
    private final MinioService minioService;
    private final SecurityUtils securityUtils;

    @Value("${minio.card-image-path}")
    private String cardImagePath;

    @Override
    public CardDto getById(Long id) {
        return objectCardMapper.toCardDto(objectCardRepository
                .findById(id)
                .orElseThrow());
    }

    @Override
    @Transactional
    public void saveCard(CardRequestDto dto, List<MultipartFile> images) {
        ObjectCard objectCard = objectCardMapper.toObjectCard(dto);
        objectCard.setCreatedBy(securityUtils.getCurrentUser());
        objectCardRepository.save(objectCard);

        // save card image
        List<Files> imageFiles = minioService.saveFiles(images,cardImagePath,objectCard.getId());
        objectCard.setImages(imageFiles);

        objectCardRepository.save(objectCard);
    }

    @Override
    public void updateCard(Long cardId, CardRequestDto dto) {
        ObjectCard objectCard = objectCardRepository.findById(cardId).orElseThrow();
        ObjectCard updatedData = objectCardMapper.toObjectCard(dto);
        updatedData.setId(objectCard.getId());
        objectCardRepository.save(updatedData);
    }

    @Override
    @Transactional
    public void addImage(Long cardId, MultipartFile file) {
        ObjectCard objectCard = objectCardRepository.findById(cardId).orElseThrow();
        Files savedImage = minioService.saveFile(file,cardImagePath,objectCard.getId());
        List<Files> images = objectCard.getImages();
        images.add(savedImage);
        objectCard.setImages(images);
        objectCardRepository.save(objectCard);
    }

    @Override
    @Transactional
    public void deleteCard(Long cardId) {
        ObjectCard objectCard = objectCardRepository.findById(cardId).orElseThrow();
        List<Long> fileIds = objectCard.getImages().stream().map(Files::getId).toList();
        minioService.deleteFilesByIds(fileIds);
        objectCardRepository.delete(objectCard);
    }

    @Override
    public Page<CardDto> searchCards(CardSearchRequest request) {
        Sort sort = Sort.by(
                "desc".equals(request.getSortDir()) ? Sort.Direction.DESC : Sort.Direction.ASC,
                request.getSortDir()
        );

        Pageable pageable = PageRequest.of(request.getPage(),
                request.getSize(),
                sort);

        Specification<ObjectCard> spec = CardObjectSpecification.build(request);

        return objectCardRepository.findAll(spec, pageable)
                .map(objectCardMapper::toCardDto);
    }
}
