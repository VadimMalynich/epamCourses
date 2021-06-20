package by.training.task04.bean;

public enum AccountStatus {
    ACTIVE("Активен"), BLOCKED("Заблокирован");
    private String value;

    AccountStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
