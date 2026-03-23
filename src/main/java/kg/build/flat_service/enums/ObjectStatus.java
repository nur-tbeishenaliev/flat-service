package kg.build.flat_service.enums;

public enum ObjectStatus {
    ACTIVE("Активный"),
    COMPLETED("Завершенный"),
    CANCELED("Отменен"),
    IN_ARCHIVE("В архиве");

    String name;

    ObjectStatus(String name){
        this.name = name;
    }
}
