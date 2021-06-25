package by.training.task04.view;

import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilterMenu {
    private static final Logger userLogger = LogManager.getLogger(FilterMenu.class);
    private static final FilterMenu instance = new FilterMenu();
    private final UserOutput print = new UserOutput();
    private final UserReader reader = new UserReader();

    public static FilterMenu getInstance() {
        return instance;
    }

    public MessageManager filterData(MessageManager messageManager) {
        Controller controller = new Controller();
        boolean flag = true;
        String message;
        while (flag) {
            String filterMenu = messageManager.getString("filterMenu");
            print.printMessage(filterMenu);
            int filterChoice = reader.enterInt(messageManager);
            switch (filterChoice) {
                case 1:
                    message = controller.executeTask("filter_status-" + 0);
                    userLogger.debug(message);
                    break;
                case 2:
                    message = controller.executeTask("filter_status-" + 1);
                    userLogger.debug(message);
                    break;
                case 3:
                    String enterBalance = messageManager.getString("enterMinBalance");
                    print.printMessage(enterBalance);
                    double min = reader.enterDouble(messageManager);
                    enterBalance = messageManager.getString("enterMaxBalance");
                    print.printMessage(enterBalance);
                    double max = reader.enterDouble(messageManager);
                    message = controller.executeTask("filter_amount-" + min + " " + max);
                    userLogger.debug(message);
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
                    userLogger.info("Wrong menu item selected in filter menu");
                    break;
            }
        }
        return messageManager;
    }
}
