package kg.build.flat_service.repository.account;

import kg.build.flat_service.entity.account.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
