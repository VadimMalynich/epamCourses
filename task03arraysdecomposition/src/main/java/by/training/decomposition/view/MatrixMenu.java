package by.training.decomposition.view;

import by.training.decomposition.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class MatrixMenu {
    private static final Logger userLogger = LogManager.getLogger(MatrixMenu.class);
    private static final MatrixMenu instance = new MatrixMenu();
    private final UserOutput print = new UserOutput();
    private final UserReader reader = new UserReader();

    private int rowsP;
    private int rowsQ;
    private int columnsP;
    private int columnsQ;


    public static MatrixMenu getInstance() {
        return instance;
    }

    public Locale doMatrixOperations(Locale locale) {
        Controller controller = new Controller();
        boolean flag = true;
        int choice;

        while (flag) {
            ResourceBundle rb = ResourceBundle.getBundle("langs.interface", locale);
            String menu = rb.getString("matrixMenu");
            print.printMessage(menu);
            choice = reader.enterInt(rb);
            switch (choice) {
                case 1:
                    enterFirstMatrixSizes(rb);
                    print.printMessage(controller.executeTask("transpose_matrix-" + rowsP + " " + columnsP));
                    break;
                case 2:
                    enterFirstMatrixSizes(rb);
                    String enterValue = rb.getString("enterValue");
                    print.printMessage(enterValue);
                    int k = reader.enterInt(rb);
                    print.printMessage(controller.executeTask("multiply_matrix_on_value-" + rowsP + " " +
                            columnsP + " " + k));
                    break;
                case 3:
                    enterTwoMatrices(rb);
                    print.printMessage(controller.executeTask("multiply_matrices-" + rowsP + " " + columnsP
                            + ";" + rowsQ + " " + columnsQ));
                    break;
                case 4:
                    enterTwoMatrices(rb);
                    print.printMessage(controller.executeTask("sum_or_diff_matrices-" + rowsP + " " + columnsP
                            + ";" + rowsQ + " " + columnsQ + "," + true));
                    break;
                case 5:
                    enterTwoMatrices(rb);
                    print.printMessage(controller.executeTask("sum_or_diff_matrices-" + rowsP + " " + columnsP
                            + ";" + rowsQ + " " + columnsQ + "," + false));
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
                    userLogger.info("Wrong menu item selected in matrix menu");
                    break;
            }
        }
        return locale;
    }

    private void enterTwoMatrices(ResourceBundle rb) {
        String enterFirst = rb.getString("firstMatrix");
        print.printMessage(enterFirst);
        enterFirstMatrixSizes(rb);
        String enterSecond = rb.getString("secondMatrix");
        print.printMessage(enterSecond);
        enterSecondMatrixSizes(rb);
    }

    private void enterFirstMatrixSizes(ResourceBundle rb) {
        String enterRows = rb.getString("enterRows");
        String enterColumns = rb.getString("enterColumns");
        print.printMessage(enterRows);
        rowsP = reader.enterInt(rb);
        print.printMessage(enterColumns);
        columnsP = reader.enterInt(rb);
    }

    private void enterSecondMatrixSizes(ResourceBundle rb) {
        String enterRows = rb.getString("enterRows");
        String enterColumns = rb.getString("enterColumns");
        print.printMessage(enterRows);
        rowsQ = reader.enterInt(rb);
        print.printMessage(enterColumns);
        columnsQ = reader.enterInt(rb);
    }
}
