package by.training.decomposition.view;

import by.training.decomposition.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayMenu {
    private static final Logger userLogger = LogManager.getLogger(ArrayMenu.class);
    private static final ArrayMenu instance = new ArrayMenu();
    private final UserOutput print = new UserOutput();
    private final UserReader reader = new UserReader();

    private int size;
    private boolean isIncreasing;

    private ArrayMenu() {
    }

    public static ArrayMenu getInstance() {
        return instance;
    }

    public MessageManager doSorting(MessageManager messageManager) {
        Controller controller = new Controller();
        boolean flag = true;
        int choice;

        while (flag) {
            String menu = messageManager.getString("arrayMenu");
            print.printMessage(menu);
            choice = reader.enterInt(messageManager);
            switch (choice) {
                case 1:
                    enterArrayConfiguration(messageManager);
                    print.printMessage(controller.executeTask("bubble_sort-" + size + " " + isIncreasing));
                    break;
                case 2:
                    enterArrayConfiguration(messageManager);
                    print.printMessage(controller.executeTask("shaker_sort-" + size + " " + isIncreasing));
                    break;
                case 3:
                    enterArrayConfiguration(messageManager);
                    print.printMessage(controller.executeTask("simple_selection_sort-" + size + " " + isIncreasing));
                    break;
                case 4:
                    enterArrayConfiguration(messageManager);
                    print.printMessage(controller.executeTask("insert_sort-" + size + " " + isIncreasing));
                    break;
                case 5:
                    enterArrayConfiguration(messageManager);
                    print.printMessage(controller.executeTask("binary_merge_sort-" + size + " " + isIncreasing));
                    break;
                case 6:
                    enterArrayConfiguration(messageManager);
                    print.printMessage(controller.executeTask("shell_sort-" + size + " " + isIncreasing));
                    break;
                case 7:
                    if ("US".equals(messageManager.getManagerCountry())) {
                        messageManager = MessageManager.RU;
                    } else {
                        messageManager = MessageManager.EN;
                    }
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    userLogger.info("Wrong menu item selected in matrix menu");
                    break;
            }
        }
        return messageManager;
    }

    private void enterArrayConfiguration(MessageManager manager) {
        String sizeArray = manager.getString("enterSize");
        print.printMessage(sizeArray);
        size = reader.enterInt(manager);
        String enterType = manager.getString("sortType");
        print.printMessage(enterType);
        isIncreasing = reader.enterBoolean(manager);
    }
}
