package kg.build.flat_service.service.request.impl;

import kg.build.flat_service.dto.requests.SellRequestCreateDto;
import kg.build.flat_service.dto.requests.SellRequestDto;
import kg.build.flat_service.dto.requests.SellRequestSearch;
import kg.build.flat_service.entity.requests.SellRequest;
import kg.build.flat_service.mapper.requests.SellRequestMapper;
import kg.build.flat_service.repository.requests.SellRequestRepository;
import kg.build.flat_service.repository.requests.specification.SellRequestSpecification;
import kg.build.flat_service.service.request.SellRequestService;
import kg.build.flat_service.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SellRequestServiceImpl
        implements SellRequestService {

    private final SellRequestRepository sellRequestRepository;
    private final SellRequestMapper sellRequestMapper;
    private final SecurityUtils securityUtils;

    @Override
    public SellRequestDto getById(Long id) {
        return sellRequestMapper.toDto(sellRequestRepository.findById(id).orElseThrow());
    }

    @Override
    public void create(SellRequestCreateDto createDto) {
        SellRequest sellRequest = sellRequestMapper.toEntity(createDto);
        sellRequest.setCreatedAt(LocalDateTime.now());
        sellRequest.setCreatedBy(securityUtils.getCurrentUser());
        sellRequestRepository.save(sellRequest);
    }

    @Override
    public void update(Long id, SellRequestCreateDto createDto) {
        SellRequest existsRequest = sellRequestRepository.findById(id).orElseThrow();
        SellRequest updatedRequest = sellRequestMapper.toEntity(createDto);
        existsRequest.setDescription(updatedRequest.getDescription());
        existsRequest.setUpdatedAt(LocalDateTime.now());
        existsRequest.setStatus(updatedRequest.getStatus());
        existsRequest.setUserForProcess(updatedRequest.getUserForProcess());
        sellRequestRepository.save(existsRequest);
    }

    @Override
    public void delete(Long id) {
        sellRequestRepository.deleteById(id);
    }

    @Override
    public Page<SellRequestDto> searchByRequest(SellRequestSearch searchRequest) {
        Sort sort = Sort.by(
                "desc".equals(searchRequest.getSortDir()) ? Sort.Direction.DESC : Sort.Direction.ASC,
                searchRequest.getSortDir()
        );

        Pageable pageable = PageRequest.of(searchRequest.getPage(),
                searchRequest.getSize(),
                sort);

        Specification<SellRequest> spec = SellRequestSpecification.build(searchRequest);

        return sellRequestRepository.findAll(spec, pageable)
                .map(sellRequestMapper::toDto);
    }
}
