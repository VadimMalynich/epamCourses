package by.training.task04.view;

import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger userLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MessageManager messageManager = MessageManager.RU;
        UserReader reader = new UserReader();
        UserOutput print = new UserOutput();
        Controller controller = new Controller();
        String message = controller.executeTask("generate_data-");
        userLogger.debug(message);
        boolean flag = true;
        int mainChoice;
        while (flag) {
            print.printMessage(messageManager.getString("mainMenu"));
            mainChoice = reader.enterInt(messageManager);
            switch (mainChoice) {
                case 1:
                    StatusChangeMenu statusChangeMenu = StatusChangeMenu.getInstance();
                    messageManager = statusChangeMenu.changeStatus(messageManager);
                    break;
                case 2:
                    AccountsSumMenu accountsSumMenu = AccountsSumMenu.getInstance();
                    messageManager = accountsSumMenu.calcSum(messageManager);
                    break;
                case 3:
                    SearchMenu searchMenu = SearchMenu.getInstance();
                    messageManager = searchMenu.searchData(messageManager);
                    break;
                case 4:
                    SortMenu sortMenu = SortMenu.getInstance();
                    messageManager = sortMenu.sortData(messageManager);
                    break;
                case 5:
                    FilterMenu filterMenu = FilterMenu.getInstance();
                    messageManager = filterMenu.filterData(messageManager);
                    break;
                case 6:
                    if ("US".equals(messageManager.getManagerCountry())) {
                        messageManager = MessageManager.RU;
                    } else {
                        messageManager = MessageManager.EN;
                    }
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    userLogger.info("Wrong menu item selected in main menu");
                    break;
            }
        }
        reader.closeScanner();
    }
}
