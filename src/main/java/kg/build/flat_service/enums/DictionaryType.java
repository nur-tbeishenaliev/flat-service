package kg.build.flat_service.enums;

import lombok.Getter;

/**
 * Don't choose the order of DictionaryType !!!
 * Enum.ordinal value start from 0
 */

@Getter
public enum DictionaryType {
    REGION("Область"),
    DISTRICT("Район"),
    SERIES("Серия"),
    STATE("Cостояние");

    private String name;

    DictionaryType(String name){
        this.name = name;
    }
}
