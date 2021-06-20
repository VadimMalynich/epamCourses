package by.training.task04.controller.command.impl;

import by.training.task04.bean.BankAccount;
import by.training.task04.controller.command.Command;
import by.training.task04.service.FindDataService;
import by.training.task04.service.ServiceException;
import by.training.task04.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Optional;

public class FindByAccountNumber implements Command {
    private static final Logger userLogger = LogManager.getLogger(FindByAccountNumber.class);

    @Override
    public String execute(String request) {
        long accountNumber = Long.parseLong(request.substring(request.indexOf('-') + 1));
        File file = new File("./src/main/resources/data/generatedData.txt");
        String response = "Search did not return any result";

        ServiceFactory factory = ServiceFactory.getInstance();
        FindDataService findDataService = factory.getFindDataService();
        Optional<BankAccount> bankAccount;
        try {
            bankAccount = findDataService.findByAccountNumber(file, accountNumber);
            if (bankAccount.isPresent()) {
                response = bankAccount.get().toString();
            }
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return response;
    }
}
