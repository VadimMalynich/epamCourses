package by.training.task01;

import java.util.Scanner;

/**
 * Class intended to find sum, difference, product and quotient between x and y
 */
public class Task {

    //Variable that stores entered value x
    private double x;
    //Variable that stores entered value y
    private double y;

    //Scanner that needed to receive data stream
    private Scanner scanner = new Scanner(System.in);


    /**
     * Method calculates the amount between x and y
     *
     * @return sum between x and y
     */
    public double sum() {
        return x + y;
    }

    /**
     * Method calculates the difference between x and y
     *
     * @return difference
     */
    public double difference() {
        return x - y;
    }

    /**
     * Method calculates the product between x and y
     *
     * @return product
     */
    public double product() {
        return x * y;
    }

    /**
     * Method calculates the quotient between x and y
     *
     * @return quotient
     */
    public double quotient() {
        return x / y;
    }

    //Method that write sum, difference, product and quotient between x and y on console
    public void writeResults() {
        System.out.println("Sum x + y = " + sum());
        System.out.println("Sum x - y = " + difference());
        System.out.println("Sum x * y = " + product());
        System.out.println("Sum x / y = " + quotient());
    }

    //Method that close scanner
    public void closeScanner() {
        scanner.close();
    }

    /**
     * Method reads the input stream
     *
     * @return entered of user correct value
     */
    public double enterValue() {
        double value;
        while (!scanner.hasNextDouble()) {
            System.out.print("No valid value was entered\nTry again: ");
            scanner.next();
        }
        value = scanner.nextDouble();
        return value;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
