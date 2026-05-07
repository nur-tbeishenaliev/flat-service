package kg.build.flat_service.mapper.requests.impl;

import kg.build.flat_service.dto.requests.BuyRequestCreateDto;
import kg.build.flat_service.dto.requests.BuyRequestDto;
import kg.build.flat_service.entity.requests.BuyRequest;
import kg.build.flat_service.enums.ObjectStatus;
import kg.build.flat_service.mapper.account.UserMapper;
import kg.build.flat_service.mapper.requests.BuyRequestMapper;
import kg.build.flat_service.repository.account.UserRepository;
import kg.build.flat_service.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyRequestMapperImpl
        implements BuyRequestMapper {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final SecurityUtils securityUtils;

    @Override
    public BuyRequestDto toDto(BuyRequest buyRequest) {
        return new BuyRequestDto()
                .setId(buyRequest.getId())
                .setDescription(buyRequest.getDescription())
                .setStatus(buyRequest.getStatus() != null ?
                        buyRequest.getStatus().toString() : null)
                .setCreatedBy(userMapper.toResponseDto(buyRequest.getCreatedBy()))
                .setCreatedAt(buyRequest.getCreatedAt())
                .setUpdatedAt(buyRequest.getUpdatedAt())
                .setUserForProcess(userMapper.toResponseDto(buyRequest.getUserForProcess()));
    }

    @Override
    public BuyRequest toEntity(BuyRequestCreateDto createDto){
        return new BuyRequest()
                .setId(createDto.getId())
                .setDescription(createDto.getDescription())
                .setStatus(ObjectStatus.valueOf(createDto.getStatus()))
                .setCreatedBy(securityUtils.getCurrentUser())
                .setUserForProcess(userRepository.findById(createDto.getUserForProcess()).orElseGet(null));
    }
}
