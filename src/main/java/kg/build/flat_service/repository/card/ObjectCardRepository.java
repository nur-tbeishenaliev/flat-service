package kg.build.flat_service.repository.card;

import kg.build.flat_service.entity.card.ObjectCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ObjectCardRepository
        extends JpaRepository<ObjectCard, Long>,
        JpaSpecificationExecutor<ObjectCard> {
}
