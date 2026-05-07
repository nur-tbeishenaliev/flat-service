package kg.build.flat_service.mapper.requests;

import kg.build.flat_service.dto.requests.BuyRequestCreateDto;
import kg.build.flat_service.dto.requests.BuyRequestDto;
import kg.build.flat_service.entity.requests.BuyRequest;

public interface BuyRequestMapper {

    BuyRequestDto toDto(BuyRequest buyRequest);

    BuyRequest toEntity(BuyRequestCreateDto createDto);

}
