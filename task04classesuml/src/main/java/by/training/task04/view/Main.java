package by.training.task04.view;

import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    private static final Logger userLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        UserReader reader = new UserReader();
        UserOutput print = new UserOutput();
        Controller controller = new Controller();
        userLogger.debug(controller.executeTask("generate_data-"));
        boolean flag = true;
        int mainChoice;
        while (flag) {
            ResourceBundle rb = ResourceBundle.getBundle("langs.text", locale);
            print.printMessage(rb.getString("mainMenu"));
            mainChoice = reader.enterInt(rb);
            switch (mainChoice) {
                case 1:
                    StatusChangeMenu statusChangeMenu = StatusChangeMenu.getInstance();
                    locale = statusChangeMenu.changeStatus(locale);
                    break;
                case 2:
                    AccountsSumMenu accountsSumMenu = AccountsSumMenu.getInstance();
                    locale = accountsSumMenu.calcSum(locale);
                    break;
                case 3:
                    SearchMenu searchMenu = SearchMenu.getInstance();
                    locale = searchMenu.searchData(locale);
                    break;
                case 4:
                    SortMenu sortMenu = SortMenu.getInstance();
                    locale = sortMenu.sortData(locale);
                    break;
                case 5:
                    FilterMenu filterMenu = FilterMenu.getInstance();
                    locale = filterMenu.filterData(locale);
                    break;
                case 6:
                    if ("US".equals(locale.getCountry())) {
                        locale = new Locale("ru", "RU");
                    } else {
                        locale = new Locale("en", "US");
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
