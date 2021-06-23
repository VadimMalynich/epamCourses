package by.training.decomposition.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;
import java.util.Scanner;

public class UserReader {
    private Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(UserReader.class);
    private static final UserOutput print = new UserOutput();
    private static final String ERROR = "errorEnter";

    public int enterInt(ResourceBundle rb) {
        String str = rb.getString(ERROR);
        int value;
        do {
            while (!scanner.hasNextInt()) {
                logger.error("No valid int value was entered");
                print.printMessage(str);
                scanner.next();
            }
            value = scanner.nextInt();
        } while (value <= 0);
        return value;
    }

    public boolean enterBoolean(ResourceBundle rb) {
        String str = rb.getString(ERROR);
        while (!scanner.hasNextBoolean()) {
            logger.error("No valid boolean value was entered");
            print.printMessage(str);
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    public void closeScanner() {
        scanner.close();
    }
}
