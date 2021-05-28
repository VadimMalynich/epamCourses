package by.training.service;

import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class UserInteraction {
    private Scanner scanner = new Scanner(System.in);
    private String menu = "1. Branches;\n2. Cycles;\n3. Exit.\n\nYour choice: ";
    private String branchesMenu = """
            1. Compare 2 values;
            2. Check the sides of the triangle for equal;
            3. Compare 2 values and return max or 0;
            4. Fire sensor;
            5. Get access;
            6. Back.
                        
            Your choice: """;

    private String cyclesMenu = """
            1. Print values;
            2. Sum of squares;
            3. Calculate value of the form: a(a+1)...(a+n-1);
            4. Find factorial;
            5. Find max digit in natural number;
            6. Back.
                        
            Your choice: """;

    public int enterInt(Logger logger) {
        while (!scanner.hasNextInt()) {
            logger.error("No valid int value was entered");
            System.out.print("No valid value was entered\nTry again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double enterDouble(Logger logger) {
        while (!scanner.hasNextDouble()) {
            logger.error("No valid double value was entered");
            System.out.print("No valid value was entered (format d,d)\nTry again: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public long enterLong(Logger logger) {
        while (!scanner.hasNextLong()) {
            logger.error("No valid long value was entered");
            System.out.print("No valid value was entered\nTry again: ");
            scanner.next();
        }
        return scanner.nextLong();
    }

    public void printMenu() {
        System.out.print(menu);
    }


    public void printBranchesMenu() {
        System.out.print(branchesMenu);
    }

    public void printCyclesMenu() {
        System.out.print(cyclesMenu);
    }

    public void closeScanner() {
        scanner.close();
    }
}
