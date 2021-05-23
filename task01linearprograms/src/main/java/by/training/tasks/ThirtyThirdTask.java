package by.training.task33;

import java.util.Scanner;

public class Task {
    private String a;

    /**
     * Method for finding serial number of a symbol,
     * and finding the previous and next symbols based on the found serial number
     */
    public void getPositions() {
        char symbol = a.charAt(0);
        int serialNumber = (int) symbol;
        System.out.println("Your input symbol: " + a.substring(0, 1) + " has serial number: " + serialNumber);
        serialNumber--;
        System.out.println("Previous symbol: " + (char) serialNumber + " has serial number: " + serialNumber);
        serialNumber += 2;
        System.out.println("Previous symbol: " + (char) serialNumber + " has serial number: " + serialNumber);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
