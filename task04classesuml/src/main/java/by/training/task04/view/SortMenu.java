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
        boolean flag = true;
        while (flag) {
            ResourceBundle rb = ResourceBundle.getBundle("langs.text", locale);
            String sortMenu = rb.getString("sortMenu");
            print.printMessage(sortMenu);
            int sortChoice = reader.enterInt(rb);
            switch (sortChoice) {
                case 1:
                    userLogger.debug(controller.executeTask("sort_data-number"));
                    break;
                case 2:
                    userLogger.debug(controller.executeTask("sort_data-numberReverse"));
                    break;
                case 3:
                    userLogger.debug(controller.executeTask("sort_data-amount"));
                    break;
                case 4:
                    userLogger.debug(controller.executeTask("sort_data-amountReverse"));
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
