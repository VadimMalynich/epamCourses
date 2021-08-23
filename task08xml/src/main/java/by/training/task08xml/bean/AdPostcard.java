package by.training.task08xml.bean;

import java.util.Calendar;

public class AdPostcard extends OldCard{
    private String company;
    private int phoneNumber;

    public AdPostcard() {
    }

    public AdPostcard(String serialNumber, String valuable, String country, Calendar year, String company, int phoneNumber) {
        super(serialNumber, valuable, country, year);
        this.company = company;
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nAdvertising postcard: ");
        sb.append(super.toString()).append("\nCompany: ").append(company);
        sb.append("\nPhone number: +37529").append(phoneNumber).append("\n");
        return sb.toString();
    }
}
