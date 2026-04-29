package kg.build.flat_service.repository.card.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import kg.build.flat_service.dto.card.CardSearchRequest;
import kg.build.flat_service.dto.dictionary.DictionaryDto;
import kg.build.flat_service.entity.card.ObjectCard;
import kg.build.flat_service.entity.dictionary.Dictionary;
import kg.build.flat_service.enums.CurrencyType;
import kg.build.flat_service.enums.ObjectStatus;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.List;
import java.util.Objects;

public class CardObjectSpecification {

    public static Specification<ObjectCard> build(CardSearchRequest req){
        return Specification
                .where(hasKeyword(req.getKeyWord()))
                .and(byRoomAmount(req.getRoomAmount()))
                .and(byCurrencyType(req.getCurrencyType()))
                .and(byStatus(req.getStatus()))
                .and(priceBetween(req.getMinPrice(), req.getMaxPrice()))
                .and(hasDictionaries(req.getDictionaryValues().values().stream()
                        .map(DictionaryDto::getId)
                        .toList()));
    }

    private static Specification<ObjectCard> hasKeyword(String keyword){
        return (root, query, cb) -> {
            if(Objects.isNull(keyword) || keyword.isBlank()){
                return null;
            }

            String pattern = "%" + keyword.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("description")), pattern),
                    cb.like(cb.lower(root.get("objectSize")), pattern),
                    cb.like(cb.lower(root.get("utilities")), pattern),
                    cb.like(cb.lower(root.get("address")), pattern)
            );
        };
    }

    private static Specification<ObjectCard> byRoomAmount(Integer roomAmount){
        return (root, query, cb) -> {
            if(Objects.isNull(roomAmount) || roomAmount <= 0){
                return null;
            }

            return cb.equal(root.get("amountOfRooms"), roomAmount);
        };
    }

    private static Specification<ObjectCard> byCurrencyType(String currencyType){
        return (root, query, cb) -> {
            if(Objects.isNull(currencyType) || currencyType.isBlank()){
                return null;
            }

            return cb.equal(root.get("currencyType"), CurrencyType.valueOf(currencyType));
        };
    }

    private static Specification<ObjectCard> byStatus(String status){
        return (root, query, cb) -> {
            if(Objects.isNull(status) || status.isBlank()){
                return null;
            }

            return cb.equal(root.get("status"), ObjectStatus.valueOf(status));
        };
    }
    private static Specification<ObjectCard> priceBetween(Double minPrice, Double maxPrice){
        return (root, query, cb) -> {

            if(Objects.isNull(minPrice) || Objects.isNull(maxPrice)){
                return null;
            }

            if(Objects.isNull(minPrice)) {
                return cb.lessThanOrEqualTo(root.get("price"), maxPrice);
            }

            if(Objects.isNull(maxPrice)) {
                return cb.greaterThanOrEqualTo(root.get("price"), minPrice);
            }

            return cb.between(root.get("price"), minPrice, maxPrice);
        };
    }

    private static Specification<ObjectCard> hasDictionaries(List<Long> dictionaries){
        return (root, query, cb) -> {
            if(Objects.isNull(dictionaries) || dictionaries.isEmpty()){
                return null;
            }

            query.distinct(true);

            List<Predicate> predicates = dictionaries.stream()
                    .map(dictionary -> {
                        Join<ObjectCard, Dictionary> join = root.join("dictionaries", JoinType.INNER);
                        return cb.equal(join.get("id"), dictionary);
                    })
                    .toList();

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
