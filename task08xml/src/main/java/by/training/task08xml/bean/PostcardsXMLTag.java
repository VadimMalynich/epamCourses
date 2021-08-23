package by.training.task08xml.bean;

public enum PostcardsXMLTag {
    POSTCARDS("postcards"), SERIAL_NUMBER("serial-number"), VALUABLE("valuable"),
    AUTHOR("author"), HOLIDAY("holiday"), POSTCARD("postcard"), AD_CARD("ad-card"),
    GREETING_CARD("greeting-card"), COUNTRY("country"), YEAR("year"), THEME("theme"),
    COMPANY("company"), PHONE_NUMBER("phone-number");

    private String value;

    PostcardsXMLTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
