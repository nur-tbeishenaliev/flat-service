package kg.build.flat_service.enums;

import lombok.Getter;

@Getter
public enum CurrencyType {
    SOM("сом"),
    DOLLAR("$");

    private String value;

    CurrencyType(String value){
        this.value = value;
    }
}
