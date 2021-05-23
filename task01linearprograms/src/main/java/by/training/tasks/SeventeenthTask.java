package by.training.task17;

import java.util.Scanner;

public class Task {
    //Variable that stores entered value a
    private double a;
    //Variable that stores entered value b
    private double b;
    //Scanner that needed to receive data stream
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method calculate geometric mean of variables a and b
     *
     * @return geometric mean of a and b
     */
    public double geometricMean() {
        double result;
        result = Math.sqrt(Math.abs(a) * Math.abs(b));
        return result;
    }

    /**
     * Method calculate average of variables a^3 and b^3
     *
     * @return average of a^3 and b^3
     */
    public double average() {
        double result;
        result = (Math.pow(a, 3) + Math.pow(b, 3)) / 2;
        return result;
    }

    //Method that write sum, difference, product and quotient between x and y on console
    public void writeResult() {
        System.out.println("Average of A and B: " + average());
        System.out.println("Geometric mean of A and B: " + geometricMean());
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

    //Method that close scanner
    public void closeScanner() {
        scanner.close();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
