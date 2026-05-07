package kg.build.flat_service.service.request;

import kg.build.flat_service.dto.requests.SellRequestCreateDto;
import kg.build.flat_service.dto.requests.SellRequestDto;
import kg.build.flat_service.dto.requests.SellRequestSearch;
import org.springframework.data.domain.Page;

public interface SellRequestService {

    SellRequestDto getById(Long id);

    void create(SellRequestCreateDto createDto);

    void update(Long id, SellRequestCreateDto createDto);

    void delete(Long id);

    Page<SellRequestDto> searchByRequest(SellRequestSearch searchRequest);

}
