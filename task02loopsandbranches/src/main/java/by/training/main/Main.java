package by.training.main;

import by.training.service.BranchesMenu;
import by.training.service.CyclesMenu;
import by.training.service.UserInteraction;
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
            menuChoice = userInteraction.enterInt(userLogger);
            switch (menuChoice) {
                case 1:
                    branchesMenu.doBranchesTasks(userLogger);
                    break;
                case 2:
                    cyclesMenu.doCyclesTasks(userLogger);
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
