package by.training.task09;

import java.util.Scanner;

/**
 * Class for finding the value of an expression using a formula:
 * a / c * b / d - ( a * b - c ) / c / d
 */
public class Task {
    //Variable that stores entered value a
    private double a;
    //Variable that stores entered value b
    private double b;
    //Variable that stores entered value c
    private double c;
    //Variable that stores entered value d
    private double d;
    //Variable that stores the result of calculations
    private double result;
    //Scanner that needed to receive data stream
    private Scanner scanner = new Scanner(System.in);

    //Method that evaluates the value of an expression
    public void calcResult() {
        result = a / c * b / d - (a * b - c) / (c * d);
        System.out.println("Final result = " + getResult());
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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
