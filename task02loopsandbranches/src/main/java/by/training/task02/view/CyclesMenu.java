package by.training.task02.view;

import by.training.task02.tasks.cycles.CyclesTasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CyclesMenu {
    private static final Logger userLogger = LogManager.getLogger(CyclesMenu.class);

    private CyclesTasks cyclesTasks;
    private UserInteraction userInteraction;
    private boolean cyclesFlag;

    public CyclesMenu() {
        cyclesTasks = new CyclesTasks();
        userInteraction = new UserInteraction();
        cyclesFlag= true;
    }

    public void doCyclesTasks() {
        int a;
        int b;
        int cyclesChoice;
        while (isCyclesFlag()) {
            try {
                userInteraction.printCyclesMenu();
                cyclesChoice = userInteraction.enterInt();
                switch (cyclesChoice) {
                    case 1:
                        System.out.print("Enter start value: ");
                        a = userInteraction.enterInt();
                        System.out.print("Enter finish value: ");
                        b = userInteraction.enterInt();
                        System.out.println(cyclesTasks.getNumbersString(a, b));
                        break;
                    case 2:
                        System.out.print("Enter finish value for calculate sum of squares: ");
                        a = userInteraction.enterInt();
                        System.out.println("Sum of squares = " + cyclesTasks.calcSumOfSquares(a));
                        break;
                    case 3:
                        System.out.print("Enter value a: ");
                        a = userInteraction.enterInt();
                        System.out.print("Enter value n: ");
                        b = userInteraction.enterInt();
                        System.out.println("Result of solving expression = " + cyclesTasks.solveExpression(a, b));
                        break;
                    case 4:
                        System.out.print("Enter the value for which the factorial will be calculated: ");
                        a = userInteraction.enterInt();
                        System.out.println(a + "! = " + cyclesTasks.calcFactorial(a));
                        break;
                    case 5:
                        long n;
                        System.out.print("Enter value: ");
                        n = userInteraction.enterLong();
                        System.out.println("Max digit in value " + n + " = " + cyclesTasks.findBiggestDigit(n));
                        break;
                    case 6:
                        setCyclesFlag(false);
                        break;
                    default:
                        System.out.println("Wrong choice!");
                        userLogger.info("User enter wrong choice in cycles menu!");
                }
            } catch (IllegalArgumentException arg) {
                userLogger.error(arg.getMessage());
                System.out.println(arg.getMessage());
            } catch (Exception e) {
                userLogger.fatal(e.toString());
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean isCyclesFlag() {
        return cyclesFlag;
    }

    public void setCyclesFlag(boolean cyclesFlag) {
        this.cyclesFlag = cyclesFlag;
    }
}
