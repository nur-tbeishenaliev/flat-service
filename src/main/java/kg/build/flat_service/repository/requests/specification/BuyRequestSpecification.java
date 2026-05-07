package kg.build.flat_service.repository.requests.specification;

import kg.build.flat_service.dto.requests.BuyRequestSearch;
import kg.build.flat_service.entity.requests.BuyRequest;
import kg.build.flat_service.enums.ObjectStatus;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class BuyRequestSpecification {

    public static Specification<BuyRequest> build(BuyRequestSearch req){
        return Specification
                .where(hasKeyword(req.getKeyWord()))
                .and(byStatus(req.getStatus()));
    }

    private static Specification<BuyRequest> hasKeyword(String keyword){
        return (root, query, cb) -> {
            if(Objects.isNull(keyword) || keyword.isBlank()){
                return null;
            }

            String pattern = "%" + keyword.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("description")),pattern)
            );
        };
    }

    private static Specification<BuyRequest> byStatus(String objectsStatus){
        return (root, query, cb) -> {
            ObjectStatus status = ObjectStatus.valueOf(objectsStatus);
            return cb.equal(root.get("status"), status);
        };
    }
}
