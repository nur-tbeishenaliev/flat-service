package kg.build.flat_service.mapper.requests.impl;

import kg.build.flat_service.dto.requests.SellRequestCreateDto;
import kg.build.flat_service.dto.requests.SellRequestDto;
import kg.build.flat_service.entity.requests.SellRequest;
import kg.build.flat_service.enums.ObjectStatus;
import kg.build.flat_service.mapper.account.UserMapper;
import kg.build.flat_service.mapper.requests.SellRequestMapper;
import kg.build.flat_service.repository.account.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SellRequestMapperImpl
        implements SellRequestMapper {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public SellRequestDto toDto(SellRequest sellRequest) {
        if(Objects.isNull(sellRequest)){
            return null;
        }

        return new SellRequestDto()
                .setId(sellRequest.getId())
                .setDescription(sellRequest.getDescription())
                .setStatus(sellRequest.getStatus().getName())
                .setCreatedBy(userMapper.toResponseDto(sellRequest.getCreatedBy()))
                .setCreatedAt(sellRequest.getCreatedAt())
                .setUpdatedAt(sellRequest.getUpdatedAt())
                .setUserForProcess(userMapper.toResponseDto(sellRequest.getUserForProcess()));
    }

    @Override
    public SellRequest toEntity(SellRequestCreateDto createDto) {
        if(Objects.isNull(createDto)){
            return null;
        }

        return new SellRequest()
                .setId(createDto.getId())
                .setDescription(createDto.getDescription())
                .setStatus(ObjectStatus.valueOf(createDto.getStatus()))
                .setUserForProcess(userRepository.findById(createDto.getId()).orElse(null));
    }

}
