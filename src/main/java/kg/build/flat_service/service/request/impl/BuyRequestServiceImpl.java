package kg.build.flat_service.service.request.impl;

import kg.build.flat_service.dto.requests.BuyRequestCreateDto;
import kg.build.flat_service.dto.requests.BuyRequestDto;
import kg.build.flat_service.dto.requests.BuyRequestSearch;
import kg.build.flat_service.mapper.requests.BuyRequestMapper;
import kg.build.flat_service.repository.requests.BuyRequestRepository;
import kg.build.flat_service.repository.requests.specification.BuyRequestSpecification;
import kg.build.flat_service.service.request.BuyRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import kg.build.flat_service.entity.requests.BuyRequest;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BuyRequestServiceImpl
        implements BuyRequestService {

    private final BuyRequestRepository buyRequestRepository;
    private final BuyRequestMapper buyRequestMapper;

    @Override
    public BuyRequestDto getById(Long id) {
        return buyRequestMapper.toDto(
                buyRequestRepository.findById(id)
                        .orElseThrow());
    }

    @Override
    public void createBuyRequest(BuyRequestCreateDto createDto) {
        BuyRequest buyRequest = buyRequestMapper.toEntity(createDto);
        buyRequest.setCreatedAt(LocalDateTime.now());
        buyRequestRepository.save(buyRequest);
    }

    @Override
    public void updateBuyRequest(Long id, BuyRequestCreateDto createDto) {
        BuyRequest existBuyRequest = buyRequestRepository.findById(id).orElseThrow();
        BuyRequest updatedBuyRequest = buyRequestMapper.toEntity(createDto);
        existBuyRequest.setDescription(updatedBuyRequest.getDescription());
        existBuyRequest.setUpdatedAt(LocalDateTime.now());
        existBuyRequest.setStatus(updatedBuyRequest.getStatus());
        existBuyRequest.setUserForProcess(updatedBuyRequest.getUserForProcess());
        buyRequestRepository.save(existBuyRequest);
    }

    @Override
    public void deleteBuyRequest(Long id) {
        buyRequestRepository.deleteById(id);
    }

    @Override
    public Page<BuyRequestDto> searchBuyRequest(BuyRequestSearch request) {
        Sort sort = Sort.by(
                "desc".equals(request.getSortDir()) ? Sort.Direction.DESC : Sort.Direction.ASC,
                request.getSortDir()
        );

        Pageable pageable = PageRequest.of(request.getPage(),
                request.getSize(),
                sort);

        Specification<BuyRequest> spec = BuyRequestSpecification.build(request);

        return buyRequestRepository.findAll(spec, pageable)
                .map(buyRequestMapper::toDto);
    }
}
