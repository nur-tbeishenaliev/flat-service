package kg.build.flat_service.dto.requests;

import kg.build.flat_service.dto.account.UserResponseDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class SellRequestDto {
    private Long id;
    private String description;
    private String status;
    private UserResponseDto createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserResponseDto userForProcess;
}
