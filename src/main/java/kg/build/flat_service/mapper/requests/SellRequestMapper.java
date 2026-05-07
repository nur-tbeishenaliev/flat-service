package kg.build.flat_service.mapper.requests;

import kg.build.flat_service.dto.requests.SellRequestCreateDto;
import kg.build.flat_service.dto.requests.SellRequestDto;
import kg.build.flat_service.entity.requests.SellRequest;

public interface SellRequestMapper {

    SellRequestDto toDto(SellRequest sellRequest);

    SellRequest toEntity(SellRequestCreateDto createDto);

}
