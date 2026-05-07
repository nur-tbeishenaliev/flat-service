package kg.build.flat_service.repository.requests;

import kg.build.flat_service.entity.requests.SellRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SellRequestRepository
        extends JpaRepository<SellRequest, Long>,
        JpaSpecificationExecutor<SellRequest>{
}
