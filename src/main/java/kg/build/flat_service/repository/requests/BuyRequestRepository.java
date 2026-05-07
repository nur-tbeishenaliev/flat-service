package kg.build.flat_service.repository.requests;

import kg.build.flat_service.entity.requests.BuyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BuyRequestRepository
        extends JpaRepository<BuyRequest, Long>,
        JpaSpecificationExecutor<BuyRequest> {
}
