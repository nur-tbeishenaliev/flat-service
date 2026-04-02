package kg.build.flat_service.repository.file;

import kg.build.flat_service.entity.file.Files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilesRepository extends JpaRepository<Files, Long> {

    List<Files> findAllByIdIn(List<Long> ids);

}
