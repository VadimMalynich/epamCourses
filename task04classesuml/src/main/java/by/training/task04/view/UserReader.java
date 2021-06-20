package by.training.task04.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;
import java.util.Scanner;

public class UserReader {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(UserReader.class);
    private static final UserOutput print = new UserOutput();

    public int enterInt(ResourceBundle rb) {
        String str = rb.getString("errorEnter");
        while (!scanner.hasNextInt()) {
            logger.error("No valid int value was entered");
            print.printMessage(str);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public boolean enterBoolean(ResourceBundle rb) {
        String str = rb.getString("errorEnter");
        while (!scanner.hasNextBoolean()) {
            logger.error("No valid boolean value was entered");
            print.printMessage(str);
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    public double enterDouble(ResourceBundle rb) {
        String str = rb.getString("errorEnter");
        while (!scanner.hasNextDouble()) {
            logger.error("No valid double value was entered");
            print.printMessage(str);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String enterString() {
        scanner.next();
        return scanner.nextLine();
    }

    public long enterLong(ResourceBundle rb) {
        String str = rb.getString("errorEnter");
        long number;
        do {
            while (!scanner.hasNextLong()) {
                logger.error("No valid long value was entered");
                print.printMessage(str);
                scanner.next();
            }
            number = scanner.nextLong();
        } while (number >= 10000000000000000l || number < 1000000000000000l);
        return number;
    }

    public void closeScanner() {
        scanner.close();
    }
}
