package by.training.task08xml.view;

import by.training.task08xml.bean.AdPostcard;
import by.training.task08xml.bean.GreetingPostcard;
import by.training.task08xml.bean.Postcard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

public class PrintPostcards {
    private static final String POSTCARD_TABLE_SEPARATOR = "--------------------------------------------------------" +
            "---------------------------------------------------------------";

    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Printing all parsed data of postcard types from xml file
     *
     * @param postcards         {@code Set<Postcard>} with parsed data
     * @param adPostcards       {@code Set<AdPostcard>} with parsed data
     * @param greetingPostcards {@code Set<GreetingPostcard>} with parsed data
     */
    public void printAllTypesPostcards(Set<Postcard> postcards, Set<AdPostcard> adPostcards,
                                       Set<GreetingPostcard> greetingPostcards) {
        printPostcards(postcards);
        printAdPostcards(adPostcards);
        printGreetingPostcards(greetingPostcards);
    }

    /**
     * Print parsed postcards data from xml file
     *
     * @param postcards {@code Set<Postcard>} with parsed data
     */
    public void printPostcards(Set<Postcard> postcards) {
        if (postcards.size() == 0) {
            System.out.println("There are no postcards received during xml file validation");
        } else {
            System.out.println("Postcards");
            System.out.println(POSTCARD_TABLE_SEPARATOR);
            System.out.println("| Serial number |    Valuable    |        Country         | Year " +
                    "|          Theme          |          Author          |");
            System.out.println(POSTCARD_TABLE_SEPARATOR);
            Iterator<Postcard> iterator = postcards.iterator();
            while (iterator.hasNext()) {
                Postcard postcard = iterator.next();
                System.out.printf("| %13s | %14s | %22s | %4d | %23s | %24s |\n", postcard.getSerialNumber(),
                        (postcard.getValuable() != null) ? postcard.getValuable() : "Тематическая",
                        postcard.getCountry(), postcard.getYear().get(Calendar.YEAR), postcard.getTheme(),
                        (postcard.getAuthor() != null) ? postcard.getAuthor() : "Unknown");
            }
            System.out.println(POSTCARD_TABLE_SEPARATOR + "\n");
        }
    }

    /**
     * Print parsed advertising postcard data from xml file
     *
     * @param adPostcards {@code Set<AdPostcard>} with parsed data
     */
    public void printAdPostcards(Set<AdPostcard> adPostcards) {
        if (adPostcards.size() == 0) {
            System.out.println("There are no advertising postcard received during xml file validation");
        } else {
            System.out.println("Advertising postcards");
            System.out.println(POSTCARD_TABLE_SEPARATOR);
            System.out.println("| Serial number |    Valuable    |        Country         | Year " +
                    "|              Company              |  Phone number  |");
            System.out.println(POSTCARD_TABLE_SEPARATOR);
            Iterator<AdPostcard> iterator = adPostcards.iterator();
            while (iterator.hasNext()) {
                AdPostcard adPostcard = iterator.next();
                System.out.printf("| %13s | %14s | %22s | %4d | %33s | %14s |\n", adPostcard.getSerialNumber(),
                        (adPostcard.getValuable() != null) ? adPostcard.getValuable() : "Тематическая",
                        adPostcard.getCountry(), adPostcard.getYear().get(Calendar.YEAR), adPostcard.getCompany(),
                        "+37529" + adPostcard.getPhoneNumber());
            }
            System.out.println(POSTCARD_TABLE_SEPARATOR + "\n");
        }
    }

    /**
     * Print parsed greeting postcard data from xml file
     *
     * @param greetingPostcards {@code Set<GreetingPostcard>} with parsed data
     */
    public void printGreetingPostcards(Set<GreetingPostcard> greetingPostcards) {
        if (greetingPostcards.size() == 0) {
            System.out.println("There are no greeting postcard received during xml file validation");
        } else {
            System.out.println("Greeting postcards");
            System.out.println(POSTCARD_TABLE_SEPARATOR);
            System.out.println("|    Serial number    |       Valuable       |            Country            |    Year    " +
                    "|          Holiday          |");
            System.out.println(POSTCARD_TABLE_SEPARATOR);
            Iterator<GreetingPostcard> iterator = greetingPostcards.iterator();
            while (iterator.hasNext()) {
                GreetingPostcard greetingPostcard = iterator.next();
                System.out.printf("| %19s | %20s | %29s | %10d | %25s |\n", greetingPostcard.getSerialNumber(),
                        (greetingPostcard.getValuable() != null) ? greetingPostcard.getValuable() : "Тематическая",
                        greetingPostcard.getCountry(), greetingPostcard.getYear().get(Calendar.YEAR),
                        getDate(greetingPostcard.getHoliday()));
            }
            System.out.println(POSTCARD_TABLE_SEPARATOR + "\n");
        }
    }

    /**
     * Converting date type {@code Calendar} into {@code String} with needed date parameters
     *
     * @param holiday date type {@code Calendar}
     * @return format {@code String} "dd MMM"
     */
    private String getDate(Calendar holiday) {
        DateFormat df = new SimpleDateFormat("dd MMM");
        return df.format(holiday.getTime());
    }
}
