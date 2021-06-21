package by.training.task04.controller.command.impl;

import by.training.task04.bean.AccountStatus;
import by.training.task04.controller.command.Command;
import by.training.task04.service.FilterDataService;
import by.training.task04.service.ServiceException;
import by.training.task04.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FilterDataStatus implements Command {
    private static final Logger userLogger = LogManager.getLogger(FilterDataStatus.class);

    @Override
    public String execute(String request) {
        int status = Integer.parseInt(request.substring(request.indexOf('-') + 1));
        File fileRead = new File("./src/main/resources/data/generatedData.txt");
        File fileWrite = new File("./src/main/resources/filteredData/filteredData.txt");
        String response = "Data did not filter";
        ServiceFactory factory = ServiceFactory.getInstance();
        FilterDataService service = factory.getFilterDataService();

        try {
            if (status == 1) {
                service.filterStatus(fileRead, fileWrite, AccountStatus.ACTIVE.getValue());
            } else {
                service.filterStatus(fileRead, fileWrite, AccountStatus.BLOCKED.getValue());
            }
            response = "Data filter successful";
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return response;
    }
}
