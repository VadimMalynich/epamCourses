package by.training.task04.view;

import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchMenu {
    private static final Logger userLogger = LogManager.getLogger(SearchMenu.class);
    private static final SearchMenu instance = new SearchMenu();
    private final UserOutput print = new UserOutput();
    private final UserReader reader = new UserReader();

    public static SearchMenu getInstance() {
        return instance;
    }

    public MessageManager searchData(MessageManager messageManager) {
        Controller controller = new Controller();
        boolean flag = true;
        String message;
        while (flag) {
            String searchMenu = messageManager.getString("searchMenu");
            print.printMessage(searchMenu);
            int searchChoice = reader.enterInt(messageManager);
            switch (searchChoice) {
                case 1:
                    String enterLong = messageManager.getString("enterAccountNumber");
                    print.printMessage(enterLong);
                    long accountNumber = reader.enterLong(messageManager);
                    message = controller.executeTask("find_by_account_number-" + accountNumber);
                    userLogger.debug(message);
                    break;
                case 2:
                    String enterFIO = messageManager.getString("enterFIO");
                    print.printMessage(enterFIO);
                    reader.enterString();
                    String fio = reader.enterString();
                    message = controller.executeTask("find_by_fio-" + fio);
                    userLogger.debug(message);
                    break;
                case 3:
                    if ("US".equals(messageManager.getManagerCountry())) {
                        messageManager = MessageManager.RU;
                    } else {
                        messageManager = MessageManager.EN;
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    userLogger.info("Wrong menu item selected in search menu");
                    break;
            }
        }
        return messageManager;
    }
}
