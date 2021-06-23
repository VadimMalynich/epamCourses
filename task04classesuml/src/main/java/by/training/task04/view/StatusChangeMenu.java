package by.training.task04.view;

import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class StatusChangeMenu {
    private static final Logger userLogger = LogManager.getLogger(StatusChangeMenu.class);
    private static final StatusChangeMenu instance = new StatusChangeMenu();
    private final UserOutput print = new UserOutput();
    private final UserReader reader = new UserReader();

    private int accountID;

    public static StatusChangeMenu getInstance() {
        return instance;
    }

    public Locale changeStatus(Locale locale) {
        Controller controller = new Controller();
        boolean flag = true;
        int choice;
        String message;
        while (flag) {
            ResourceBundle rb = ResourceBundle.getBundle("langs.text", locale);
            String menu = rb.getString("statusMenu");
            print.printMessage(menu);
            choice = reader.enterInt(rb);
            switch (choice) {
                case 1:
                    message = controller.executeTask("block_activate_all-false");
                    userLogger.debug(message);
                    break;
                case 2:
                    message = controller.executeTask("block_activate_all-true");
                    userLogger.debug(message);
                    break;
                case 3:

                    String blockId = rb.getString("blockID");
                    print.printMessage(blockId);
                    accountID = reader.enterInt(rb);
                    message = controller.executeTask("block_activate_by_id-false " + accountID);
                    userLogger.debug(message);
                    break;
                case 4:
                    String activeId = rb.getString("activeID");
                    print.printMessage(activeId);
                    accountID = reader.enterInt(rb);
                    message = controller.executeTask("block_activate_by_id-true " + accountID);
                    userLogger.debug(message);
                    break;
                case 5:
                    if ("US".equals(locale.getCountry())) {
                        locale = new Locale("ru", "RU");
                    } else {
                        locale = new Locale("en", "US");
                    }
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    userLogger.info("Wrong menu item selected in status menu");
                    break;
            }
        }
        return locale;
    }

}
