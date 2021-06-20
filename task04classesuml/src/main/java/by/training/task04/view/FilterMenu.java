package by.training.task04.view;

import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class FilterMenu {
    private static final Logger userLogger = LogManager.getLogger(FilterMenu.class);
    private static final FilterMenu instance = new FilterMenu();
    private final UserOutput print = new UserOutput();
    private final UserReader reader = new UserReader();

    public static FilterMenu getInstance() {
        return instance;
    }

    public Locale filterData(Locale locale) {
        Controller controller = new Controller();
        boolean flag = true;
        while (flag) {
            ResourceBundle rb = ResourceBundle.getBundle("langs.text", locale);

            String filterMenu = rb.getString("filterMenu");
            print.printMessage(filterMenu);
            int filterChoice = reader.enterInt(rb);
            switch (filterChoice) {
                case 1:
                    userLogger.debug(controller.executeTask("filter_status-" + 0));
                    break;
                case 2:
                    userLogger.debug(controller.executeTask("filter_status-" + 1));
                    break;
                case 3:
                    String message = rb.getString("enterMinBalance");
                    print.printMessage(message);
                    double min = reader.enterDouble(rb);
                    message = rb.getString("enterMaxBalance");
                    print.printMessage(message);
                    double max = reader.enterDouble(rb);
                    userLogger.debug(controller.executeTask("filter_amount-" + min + " " + max));
                    break;
                case 4:
                    if ("US".equals(locale.getCountry())) {
                        locale = new Locale("ru", "RU");
                    } else {
                        locale = new Locale("en", "US");
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
        return locale;
    }
}
