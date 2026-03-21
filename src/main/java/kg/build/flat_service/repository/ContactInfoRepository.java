package kg.build.flat_service.repository;

import kg.build.flat_service.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
