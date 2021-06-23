package by.training.decomposition.view;

import by.training.decomposition.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

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

    public Locale doSorting(Locale locale) {
        Controller controller = new Controller();
        boolean flag = true;
        int choice;

        while (flag) {
            ResourceBundle rb = ResourceBundle.getBundle("langs.interface", locale);
            String menu = rb.getString("arrayMenu");
            print.printMessage(menu);
            choice = reader.enterInt(rb);
            switch (choice) {
                case 1:
                    enterArrayConfiguration(rb);
                    print.printMessage(controller.executeTask("bubble_sort-" + size + " " + isIncreasing));
                    break;
                case 2:
                    enterArrayConfiguration(rb);
                    print.printMessage(controller.executeTask("shaker_sort-" + size + " " + isIncreasing));
                    break;
                case 3:
                    enterArrayConfiguration(rb);
                    print.printMessage(controller.executeTask("simple_selection_sort-" + size + " " + isIncreasing));
                    break;
                case 4:
                    enterArrayConfiguration(rb);
                    print.printMessage(controller.executeTask("insert_sort-" + size + " " + isIncreasing));
                    break;
                case 5:
                    enterArrayConfiguration(rb);
                    print.printMessage(controller.executeTask("binary_merge_sort-" + size + " " + isIncreasing));
                    break;
                case 6:
                    enterArrayConfiguration(rb);
                    print.printMessage(controller.executeTask("shell_sort-" + size + " " + isIncreasing));
                    break;
                case 7:
                    if ("US".equals(locale.getCountry())) {
                        locale = new Locale("ru", "RU");
                    } else {
                        locale = new Locale("en", "US");
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
        return locale;
    }

    private void enterArrayConfiguration(ResourceBundle rb) {
        String sizeArray = rb.getString("enterSize");
        print.printMessage(sizeArray);
        size = reader.enterInt(rb);
        String enterType = rb.getString("sortType");
        print.printMessage(enterType);
        isIncreasing = reader.enterBoolean(rb);
    }
}
