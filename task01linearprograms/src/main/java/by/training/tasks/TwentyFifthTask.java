package by.training.task25;

import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Task {
    //Variable that stores entered value a
    private double a;
    //Variable that stores entered value b
    private double b;
    //Variable that stores entered value c
    private double c;
    //Variable that stores the value of the first root
    private double x1;
    //Variable that stores the value of the second root
    private double x2;
    //Scanner that needed to receive data stream
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method calculates the discriminant based on which it searches for the roots of the equation
     *
     * @param logger for log information
     */
    public void calcRoots(Logger logger) {
        double discriminant;
        discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("Discriminant < 0.\nThe equation has no roots");
            logger.warn("Discriminant < 0.\nThe equation has no roots");
        } else if (discriminant == 0) {
            x1 = -b / 2 / a;
            System.out.println("The equation has one root x = " + x1);
            logger.info("The equation has one root x = " + x1);
        } else {
            x1 = (-b + Math.sqrt(discriminant)) / 2 / a;
            x2 = (-b - Math.sqrt(discriminant)) / 2 / a;
            System.out.println("The equation has 2  different roots x1 = " + x1 + "; x2 = " + x2);
            logger.info("The equation has 2  different roots x1 = " + x1 + "; x2 = " + x2);
        }
    }

    /**
     * Method reads the input stream
     *
     * @param flag used for impossible input 0 for variable a
     * @return entered of user correct value
     */
    public double enterValue(boolean flag) {
        double value = 0;
        while (value == 0) {
            while (!scanner.hasNextDouble()) {
                System.out.print("No valid value was entered\nTry again: ");
                scanner.next();
            }
            value = scanner.nextDouble();
            if (value == 0 && !flag) {
                System.out.println("Enter value > or < 0!");
            }
        }
        return value;
    }

    //Method that close scanner
    public void closeScanner() {
        scanner.close();
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public void setB(double b) {
        this.b = b;
    }


    public void setC(double c) {
        this.c = c;
    }
}
