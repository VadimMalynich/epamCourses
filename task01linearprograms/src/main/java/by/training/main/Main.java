package by.training.task01;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Class for creating an instance of an object and using it to interact with the user
public class Main {
    private static final Logger rootLogger = LogManager.getRootLogger();

    public static void main(String[] args) {
        Task task = new Task();
        System.out.print("Enter value x (format d,d): ");
        task.setX(task.enterValue());
        System.out.print("Enter value y (format d,d): ");
        task.setY(task.enterValue());
        task.writeResults();
        rootLogger.info("Y = " + task.getY());
        rootLogger.info("X = " + task.getX());
        rootLogger.debug("Quotient = " + task.quotient());
        rootLogger.warn("Quotient = " + task.quotient());
        task.closeScanner();
    }
}
