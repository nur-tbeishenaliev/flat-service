package kg.build.flat_service.mapper.file;

import kg.build.flat_service.dto.file.ImageDto;
import kg.build.flat_service.entity.file.Files;

public interface FileMapper {

    ImageDto toDto(Files file);

}
