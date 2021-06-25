package by.training.decomposition.view;

import by.training.decomposition.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public MessageManager doMatrixOperations(MessageManager messageManager) {
        Controller controller = new Controller();
        boolean flag = true;
        int choice;
        while (flag) {
            String menu = messageManager.getString("matrixMenu");
            print.printMessage(menu);
            choice = reader.enterInt(messageManager);
            switch (choice) {
                case 1:
                    enterFirstMatrixSizes(messageManager);
                    print.printMessage(controller.executeTask("transpose_matrix-" + rowsP + " " + columnsP));
                    break;
                case 2:
                    enterFirstMatrixSizes(messageManager);
                    String enterValue = messageManager.getString("enterValue");
                    print.printMessage(enterValue);
                    int k = reader.enterInt(messageManager);
                    print.printMessage(controller.executeTask("multiply_matrix_on_value-" + rowsP + " " +
                            columnsP + " " + k));
                    break;
                case 3:
                    enterTwoMatrices(messageManager);
                    print.printMessage(controller.executeTask("multiply_matrices-" + rowsP + " " + columnsP
                            + ";" + rowsQ + " " + columnsQ));
                    break;
                case 4:
                    enterTwoMatrices(messageManager);
                    print.printMessage(controller.executeTask("sum_or_diff_matrices-" + rowsP + " " + columnsP
                            + ";" + rowsQ + " " + columnsQ + "," + true));
                    break;
                case 5:
                    enterTwoMatrices(messageManager);
                    print.printMessage(controller.executeTask("sum_or_diff_matrices-" + rowsP + " " + columnsP
                            + ";" + rowsQ + " " + columnsQ + "," + false));
                    break;
                case 6:
                    if ("US".equals(messageManager.getManagerCountry())) {
                        messageManager = MessageManager.RU;
                    } else {
                        messageManager = MessageManager.EN;
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
        return messageManager;
    }

    private void enterTwoMatrices(MessageManager manager) {
        String enterFirst = manager.getString("firstMatrix");
        print.printMessage(enterFirst);
        enterFirstMatrixSizes(manager);
        String enterSecond = manager.getString("secondMatrix");
        print.printMessage(enterSecond);
        enterSecondMatrixSizes(manager);
    }

    private void enterFirstMatrixSizes(MessageManager manager) {
        String enterRows = manager.getString("enterRows");
        String enterColumns = manager.getString("enterColumns");
        print.printMessage(enterRows);
        rowsP = reader.enterInt(manager);
        print.printMessage(enterColumns);
        columnsP = reader.enterInt(manager);
    }

    private void enterSecondMatrixSizes(MessageManager manager) {
        String enterRows = manager.getString("enterRows");
        String enterColumns = manager.getString("enterColumns");
        print.printMessage(enterRows);
        rowsQ = reader.enterInt(manager);
        print.printMessage(enterColumns);
        columnsQ = reader.enterInt(manager);
    }
}
