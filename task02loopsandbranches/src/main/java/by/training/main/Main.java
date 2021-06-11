package by.training.main;

import by.training.view.BranchesMenu;
import by.training.view.CyclesMenu;
import by.training.view.UserInteraction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger userLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        UserInteraction userInteraction = new UserInteraction();
        BranchesMenu branchesMenu = new BranchesMenu();
        CyclesMenu cyclesMenu = new CyclesMenu();
        int menuChoice;
        boolean menuFlag = true;
        while (menuFlag) {
            userInteraction.printMenu();
            menuChoice = userInteraction.enterInt();
            switch (menuChoice) {
                case 1:
                    branchesMenu.doBranchesTasks();
                    break;
                case 2:
                    cyclesMenu.doCyclesTasks();
                    break;
                case 3:
                    menuFlag = false;
                    break;
                default:
                    System.out.println("Wrong choice!");
                    userLogger.info("User enter wrong choice in main menu!");
                    break;
            }
        }
        userInteraction.closeScanner();
    }
}
