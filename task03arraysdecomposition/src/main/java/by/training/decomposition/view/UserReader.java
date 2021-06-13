package by.training.decomposition.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;
import java.util.Scanner;

public class UserReader {
    private Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(UserReader.class);

    public int enterInt(ResourceBundle rb) {
        String str = rb.getString("errorEnter");
        while (!scanner.hasNextInt()) {
            logger.error("No valid int value was entered");
            System.out.print(str);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public boolean enterBoolean(ResourceBundle rb) {
        String str = rb.getString("errorEnter");
        while (!scanner.hasNextBoolean()) {
            logger.error("No valid boolean value was entered");
            System.out.print(str);
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    public void closeScanner() {
        scanner.close();
    }
}
