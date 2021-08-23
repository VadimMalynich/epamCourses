package by.training.task08xml.bean;

import java.util.Calendar;

public abstract class OldCard {
    private String serialNumber;
    private String valuable;
    private String country;
    private Calendar year;

    public OldCard() {
    }

    public OldCard(String serialNumber, String valuable, String country, Calendar year) {
        this.serialNumber = serialNumber;
        this.valuable = valuable;
        this.country = country;
        this.year = year;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getValuable() {
        return valuable;
    }

    public void setValuable(String valuable) {
        this.valuable = valuable;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Calendar getYear() {
        return year;
    }

    public void setYear(Calendar year) {
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nSerialNumber: ");
        sb.append(serialNumber).append("\nValuable: ").append(valuable).append("\nCountry: ").append(country);
        sb.append("\nYear: ").append(year.get(Calendar.YEAR));
        return sb.toString();
    }
}
