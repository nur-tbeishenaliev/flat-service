package kg.build.flat_service.service.request;

import kg.build.flat_service.dto.requests.BuyRequestCreateDto;
import kg.build.flat_service.dto.requests.BuyRequestDto;
import kg.build.flat_service.dto.requests.BuyRequestSearch;
import org.springframework.data.domain.Page;

public interface BuyRequestService {

    BuyRequestDto getById(Long id);

    void createBuyRequest(BuyRequestCreateDto createDto);

    void updateBuyRequest(Long id,
                          BuyRequestCreateDto createDto);

    void deleteBuyRequest(Long id);

    Page<BuyRequestDto> searchBuyRequest(BuyRequestSearch searchRequest);

}
