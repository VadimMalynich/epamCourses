package by.training.task08xml.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GreetingPostcard extends OldCard {
    private Calendar holiday;

    public GreetingPostcard() {
    }

    public GreetingPostcard(String serialNumber, String valuable, String country, Calendar year, Calendar holiday) {
        super(serialNumber, valuable, country, year);
        this.holiday = holiday;
    }

    public Calendar getHoliday() {
        return holiday;
    }

    public void setHoliday(Calendar holiday) {
        this.holiday = holiday;
    }

    private String getDate() {
        DateFormat df = new SimpleDateFormat("dd MMM");
        return df.format(holiday.getTime());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nGreeting postcard: ");
        sb.append(super.toString()).append("\nHoliday: ");
//        sb.append(holiday.get(Calendar.MONTH)).append(" ").append(holiday.get(Calendar.DAY_OF_MONTH));
        sb.append(getDate()).append("\n");
        return sb.toString();
    }


}
