package by.training.informationhandling.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class UserReader {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(UserReader.class);
    private static final UserOutput print = new UserOutput();

    public int enterInt() {
        while (!scanner.hasNextInt()) {
            logger.error("No valid int value was entered");
            System.out.println("No valid int value was entered");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public boolean enterBoolean() {
        while (!scanner.hasNextBoolean()) {
            logger.error("No valid boolean value was entered");
            print.printMessage("No valid boolean value was entered");
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    public double enterDouble() {
        while (!scanner.hasNextDouble()) {
            logger.error("No valid double value was entered");
            print.printMessage("No valid double value was entered");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String enterString() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
