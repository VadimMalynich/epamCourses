package by.training.main;


import by.training.tasks.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

// Class for creating an instance of an object and using it to interact with the user
public class Main {
    private static final Logger userLogger = LogManager.getLogger(Main.class);
    private static final String MENU = "\n1. Sum, difference, product, quotient;\n" +
            "2. Calculating the value of an expression;\n" +
            "3. Average and geometric mean;\n" +
            "4. Quadratic equation;\n" +
            "5. Serial number of symbol;\n" +
            "6. Exit.\n\n" +
            "Your choice: ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            try {
                System.out.print(MENU);
                int choice = enterChoice(scanner);
                switch (choice) {
                    case 1: {
                        FirstTask firstTask = new FirstTask();
                        double x;
                        double y;
                        System.out.print("Enter x: ");
                        x = enterValue(scanner);
                        System.out.print("Enter y: ");
                        y = enterValue(scanner);
                        System.out.println("X = " + x + "; Y = " + y);
                        System.out.println("x + y = " + firstTask.sum(x, y) + ";\nx - y = " + firstTask.difference(x, y) +
                                ";\nx * y = " + firstTask.product(x, y) + "; ");
                        System.out.println("x / y = " + firstTask.quotient(x, y));
                        break;
                    }
                    case 2: {
                        NinthTask ninthTask = new NinthTask();
                        double a;
                        double b;
                        double c;
                        double d;
                        System.out.print("Enter a: ");
                        a = enterValue(scanner);
                        System.out.print("Enter b: ");
                        b = enterValue(scanner);
                        System.out.print("Enter c: ");
                        c = enterValue(scanner);
                        System.out.print("Enter d: ");
                        d = enterValue(scanner);
                        System.out.println("Expression: a / c * b / d - ( a * b - c ) / c / d = " + ninthTask.calcResult(a, b, c, d));
                        break;
                    }
                    case 3: {
                        SeventeenthTask seventeenthTask = new SeventeenthTask();
                        double a;
                        double b;
                        System.out.print("Enter a: ");
                        a = enterValue(scanner);
                        System.out.print("Enter b: ");
                        b = enterValue(scanner);
                        System.out.println("Average " + a + " and " + b + " = " + seventeenthTask.average(a, b) + ";\n" +
                                "Geometrical mean " + a + " and " + b + " = " + seventeenthTask.geometricMean(a, b));
                        break;
                    }
                    case 4: {
                        TwentyFifthTask twentyFifthTask = new TwentyFifthTask();
                        double a;
                        double b;
                        double c;
                        double discriminant;
                        System.out.print("Enter a: ");
                        a = enterValue(scanner);
                        System.out.print("Enter b: ");
                        b = enterValue(scanner);
                        System.out.print("Enter c: ");
                        c = enterValue(scanner);
                        discriminant = twentyFifthTask.calcDiscriminant(a, b, c);
                        userLogger.info(discriminant);
                        if (discriminant < 0) {
                            throw new IllegalArgumentException("Discriminant < 0");
                        } else if (discriminant == 0) {
                            System.out.println("x1 = x2 = " + twentyFifthTask.calcTwoRoots(a, b));
                        } else {
                            System.out.println("First root x1 = " + twentyFifthTask.calcFirstRoot(a, b, discriminant) +
                                    ";\nSecond root x2 = " + twentyFifthTask.calcSecondRoot(a, b, discriminant));
                        }
                        break;
                    }
                    case 5: {
                        ThirtyThirdTask thirtyThirdTask = new ThirtyThirdTask();
                        String str;
                        int serialNumber;
                        System.out.print("Enter symbol: ");
                        str = scanner.next();
                        serialNumber = thirtyThirdTask.getPositions(str);
                        System.out.println("Symbol " + str.charAt(0) + " have serial number = " + serialNumber);
                        System.out.println("Previous symbol: " + thirtyThirdTask.getPreviousSymbol(serialNumber));
                        System.out.println("Next symbol: " + thirtyThirdTask.getNextSymbol(serialNumber));
                        break;
                    }
                    case 6: {
                        flag = false;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Wrong choice");
                    }
                }
            } catch (IllegalArgumentException arg) {
                userLogger.error(arg.getMessage());
            } catch (Exception e) {
                userLogger.fatal(e.toString());
            }
        }
        scanner.close();
    }

    public static int enterChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            userLogger.trace("No valid int value was entered");
            System.out.println("No valid value was entered\nTry again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }


    public static double enterValue(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            userLogger.info("No valid double value was entered");
            System.out.print("No valid value was entered (format d,d)\nTry again: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
