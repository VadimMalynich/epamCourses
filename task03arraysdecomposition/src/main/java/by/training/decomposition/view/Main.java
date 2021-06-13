package by.training.decomposition.view;

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
        boolean flag = true;
        int mainChoice;

        while (flag) {
            ResourceBundle rb = ResourceBundle.getBundle("langs.interface", locale);
            String menu = rb.getString("mainMenu");
            print.printMessage(menu);
            mainChoice = reader.enterInt(rb);
            switch (mainChoice) {
                case 1:
                    MatrixMenu matrixMenu = MatrixMenu.getInstance();
                    locale = matrixMenu.doMatrixOperations(locale);
                    break;
                case 2:
                    ArrayMenu arrayMenu = ArrayMenu.getInstance();
                    locale = arrayMenu.doSorting(locale);
                    break;
                case 3:
                    if ("US".equals(locale.getCountry())) {
                        locale = new Locale("ru", "RU");
                    } else {
                        locale = new Locale("en", "US");
                    }
                    break;
                case 4:
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
