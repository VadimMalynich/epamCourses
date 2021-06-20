package by.training.task04.controller.command.impl;

import by.training.task04.controller.command.Command;
import by.training.task04.service.FilterDataService;
import by.training.task04.service.ServiceException;
import by.training.task04.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FilterDataBalance implements Command {
    private static final Logger userLogger = LogManager.getLogger(FilterDataBalance.class);

    @Override
    public String execute(String request) {
        double min = Double.parseDouble(request.substring(request.indexOf('-') + 1, request.indexOf(' ')));
        double max = Double.parseDouble(request.substring(request.indexOf(' ') + 1));
        File fileRead = new File("./src/main/resources/data/generatedData.txt");
        File fileWrite = new File("./src/main/resources/filteredData/sortData.txt");
        String response = "Data did not filter";
        ServiceFactory factory = ServiceFactory.getInstance();
        FilterDataService service = factory.getFilterDataService();

        try {
            service.filterAmount(fileRead, fileWrite, min, max);
            response = "Data filter successful";
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return response;
    }
}
