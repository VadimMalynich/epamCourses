package by.training.task08xml.bean;

import java.util.Calendar;

public class Postcard extends OldCard {
    private String theme;
    private String author;

    public Postcard() {
    }

    public Postcard(String serialNumber, String valuable, String country, Calendar year, String theme, String author) {
        super(serialNumber, valuable, country, year);
        this.theme = theme;
        this.author = author;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nPostcard: ");
        sb.append(super.toString()).append("\nTheme: ").append(theme).append("\nAuthor: ").append(author).append("\n");
        return sb.toString();
    }
}
