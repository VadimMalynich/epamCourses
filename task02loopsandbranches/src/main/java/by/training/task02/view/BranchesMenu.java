package by.training.task02.view;

import by.training.task02.tasks.branches.BranchesTasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BranchesMenu {
    private static final Logger userLogger = LogManager.getLogger(BranchesMenu.class);

    private BranchesTasks branchesTasks;
    private UserInteraction userInteraction;
    private boolean branchesFlag;

    public BranchesMenu() {
        branchesTasks = new BranchesTasks();
        userInteraction = new UserInteraction();
        branchesFlag = true;
    }

    public void doBranchesTasks() {
        int branchesChoice;
        int a;
        int b;
        while (isBranchesFlag()) {
            try {
                userInteraction.printBranchesMenu();
                branchesChoice = userInteraction.enterInt();
                switch (branchesChoice) {
                    case 1:
                        System.out.print("Enter first value: ");
                        a = userInteraction.enterInt();
                        System.out.print("Enter second value: ");
                        b = userInteraction.enterInt();
                        System.out.println("Biggest value is " + branchesTasks.comparison(a, b));
                        break;
                    case 2:
                        int c;
                        System.out.print("Enter first side: ");
                        a = userInteraction.enterInt();
                        System.out.print("Enter second side: ");
                        b = userInteraction.enterInt();
                        System.out.print("Enter third side: ");
                        c = userInteraction.enterInt();
                        if (branchesTasks.isEquilateralTriangle(a, b, c)) {
                            System.out.println("Triangle have 3 equal side!");
                        } else {
                            System.out.println("Versatile triangle!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter first value: ");
                        a = userInteraction.enterInt();
                        System.out.print("Enter second value: ");
                        b = userInteraction.enterInt();
                        int temp = branchesTasks.checkNumbersEquals(a, b);
                        if (temp == 0) {
                            System.out.println("The values are the same therefore a = b = " + temp);
                        } else {
                            a = temp;
                            b = temp;
                            System.out.println("The values are not same therefore a = " + a + " and b = " + b);
                        }
                        break;
                    case 4:
                        double temperature;
                        System.out.print("Enter temperature: ");
                        temperature = userInteraction.enterDouble();
                        System.out.println(branchesTasks.checkTemperatureForNormal(temperature));
                        break;
                    case 5:
                        System.out.print("Enter password: ");
                        a = userInteraction.enterInt();
                        System.out.println(branchesTasks.checkPassword(a));
                        break;
                    case 6:
                        setBranchesFlag(false);
                        break;
                    default:
                        System.out.println("Wrong choice!");
                        userLogger.info("User enter wrong choice in branches menu!");
                }
            } catch (IllegalArgumentException arg) {
                userLogger.warn(arg.getMessage());
                System.out.println(arg.getMessage());
            } catch (Exception e) {
                userLogger.fatal(e.toString());
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean isBranchesFlag() {
        return branchesFlag;
    }

    public void setBranchesFlag(boolean branchesFlag) {
        this.branchesFlag = branchesFlag;
    }
}
