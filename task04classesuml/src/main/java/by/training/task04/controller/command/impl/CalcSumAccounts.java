package by.training.task04.controller.command.impl;

import by.training.task04.controller.command.Command;
import by.training.task04.service.CalcAccountsAmountService;
import by.training.task04.service.ServiceException;
import by.training.task04.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class CalcSumAccounts implements Command {
    private static final Logger userLogger = LogManager.getLogger(CalcSumAccounts.class);

    @Override
    public String execute(String request) {
        int flag = Integer.parseInt(request.substring(request.indexOf('-') + 1));
        File file = new File("./src/main/resources/data/generatedData.txt");
        double sum = 0;

        ServiceFactory factory = ServiceFactory.getInstance();
        CalcAccountsAmountService calcAccountsAmountService = factory.getCalcAccountsAmountService();

        try {
            switch (flag) {
                case 1:
                    sum = calcAccountsAmountService.calcAllAccountsAmount(file);
                    break;
                case 2:
                    sum = calcAccountsAmountService.calcPositiveAccountsAmount(file);
                    break;
                case 3:
                    sum = calcAccountsAmountService.calcNegativeAccountsAmount(file);
                    break;
                default:
                    userLogger.warn("Wrong value for calc sum");
                    break;
            }

        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return String.valueOf(sum);
    }
}
