package by.training.task04.view;

import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class SortMenu {
    private static final Logger userLogger = LogManager.getLogger(SortMenu.class);
    private static final SortMenu instance = new SortMenu();
    private final UserOutput print = new UserOutput();
    private final UserReader reader = new UserReader();

    public static SortMenu getInstance() {
        return instance;
    }

    public Locale sortData(Locale locale) {
        Controller controller = new Controller();
        String message;
        boolean flag = true;
        while (flag) {
            ResourceBundle rb = ResourceBundle.getBundle("langs.text", locale);
            String sortMenu = rb.getString("sortMenu");
            print.printMessage(sortMenu);
            int sortChoice = reader.enterInt(rb);
            switch (sortChoice) {
                case 1:
                    message = controller.executeTask("sort_data-number");
                    userLogger.debug(message);
                    break;
                case 2:
                    message = controller.executeTask("sort_data-numberReverse");
                    userLogger.debug(message);
                    break;
                case 3:
                    message = controller.executeTask("sort_data-amount");
                    userLogger.debug(message);
                    break;
                case 4:
                    message = controller.executeTask("sort_data-amountReverse");
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
                    userLogger.info("Wrong menu item selected in sort menu");
                    break;
            }
        }
        return locale;
    }
}
