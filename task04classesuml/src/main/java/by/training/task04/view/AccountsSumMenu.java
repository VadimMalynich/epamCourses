package by.training.task04.view;

import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountsSumMenu {
    private static final Logger userLogger = LogManager.getLogger(AccountsSumMenu.class);
    private static final AccountsSumMenu instance = new AccountsSumMenu();
    private final UserOutput print = new UserOutput();
    private final UserReader reader = new UserReader();

    public static AccountsSumMenu getInstance() {
        return instance;
    }

    public MessageManager calcSum(MessageManager messageManager) {
        Controller controller = new Controller();
        boolean flag = true;
        int choice;
        String message;
        while (flag) {
            String menu = messageManager.getString("accountsSumMenu");
            print.printMessage(menu);
            choice = reader.enterInt(messageManager);
            switch (choice) {
                case 1:
                    message = messageManager.getString("sumAllAccounts");
                    print.printMessage(message + controller.executeTask("calc_balance_sum-1"));
                    break;
                case 2:
                    message = messageManager.getString("sumPositiveAccounts");
                    print.printMessage(message + controller.executeTask("calc_balance_sum-2"));
                    break;
                case 3:
                    message = messageManager.getString("sumNegativeAccounts");
                    print.printMessage(message + controller.executeTask("calc_balance_sum-3"));
                    break;
                case 4:
                    if ("US".equals(messageManager.getManagerCountry())) {
                        messageManager = MessageManager.RU;
                    } else {
                        messageManager = MessageManager.EN;
                    }
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    userLogger.info("Wrong menu item selected in balance sum menu");
                    break;
            }
        }
        return messageManager;
    }
}
