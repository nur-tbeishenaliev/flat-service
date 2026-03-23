package kg.build.flat_service.enums;

import lombok.Getter;

@Getter
public enum OfferType {
    SALE("Продажа"),
    RENT("Аренда");

    private String description;

    OfferType(String description) {
        this.description = description;
    }
}
