package by.training.task08xml.service.validators;

import by.training.task08xml.bean.PostcardsXMLTag;

import java.rmi.ServerException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidateData {
    /**
     * Method for converting string with data into appropriate date type
     *
     * @param data {@code String} with date
     * @return data converted to date type {@code Calendar}
     */
    public static Calendar convertYear(String data) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, Integer.parseInt(data));
        return calendar;
    }

    /**
     * Method for converting string with data into appropriate date type
     *
     * @param data {@code String} with date
     * @return data converted to date type {@code Calendar}
     */
    public static Calendar convertHoliday(String data) {
        Calendar calendar = new GregorianCalendar();
        data = data.replace('-', ' ').trim();
        String dateArray[] = data.split("\\s+");
        calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[0]) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[1]));
        return calendar;
    }
}
