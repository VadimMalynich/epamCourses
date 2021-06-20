package by.training.task04.controller.command.impl;

import by.training.task04.controller.command.Command;
import by.training.task04.service.ServiceException;
import by.training.task04.service.ServiceFactory;
import by.training.task04.service.SortAccountsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class SortData implements Command {
    private static final Logger userLogger = LogManager.getLogger(SortData.class);

    @Override
    public String execute(String request) {
        String sort = request.substring(request.indexOf('-') + 1);
        File fileRead = new File("./src/main/resources/data/generatedData.txt");
        File fileWrite = new File("./src/main/resources/sortedData/sortData.txt");
        String response = "Data did not sort";
        ServiceFactory factory = ServiceFactory.getInstance();
        SortAccountsService service = factory.getSortAccountsService();

        try {
            service.sortAccounts(fileRead, fileWrite, sort);
            response = "Data sort successful";
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return response;
    }
}
