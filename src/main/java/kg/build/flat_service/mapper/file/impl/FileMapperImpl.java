package kg.build.flat_service.mapper.file.impl;

import kg.build.flat_service.dto.file.ImageDto;
import kg.build.flat_service.entity.file.Files;
import kg.build.flat_service.mapper.file.FileMapper;
import org.springframework.stereotype.Service;

@Service
public class FileMapperImpl implements FileMapper {

    @Override
    public ImageDto toDto(Files file) {
        return new ImageDto()
                .setId(file.getId())
                .setFileName(file.getFileName());
    }

}
