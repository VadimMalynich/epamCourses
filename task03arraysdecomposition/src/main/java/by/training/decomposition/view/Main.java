package by.training.decomposition.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger userLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MessageManager messageManager = MessageManager.RU;
        UserReader reader = new UserReader();
        UserOutput print = new UserOutput();
        boolean flag = true;
        int mainChoice;

        while (flag) {
            String menu = messageManager.getString("mainMenu");
            print.printMessage(menu);
            mainChoice = reader.enterInt(messageManager);
            switch (mainChoice) {
                case 1:
                    MatrixMenu matrixMenu = MatrixMenu.getInstance();
                    messageManager = matrixMenu.doMatrixOperations(messageManager);
                    break;
                case 2:
                    ArrayMenu arrayMenu = ArrayMenu.getInstance();
                    messageManager = arrayMenu.doSorting(messageManager);
                    break;
                case 3:
                    if ("US".equals(messageManager.getManagerCountry())) {
                        messageManager = MessageManager.RU;
                    } else {
                        messageManager = MessageManager.EN;
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
