package by.training.task04.controller.command.impl;

import by.training.task04.bean.Client;
import by.training.task04.controller.command.Command;
import by.training.task04.service.FindDataService;
import by.training.task04.service.ServiceException;
import by.training.task04.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Optional;

public class FindByFIO implements Command {
    private static final Logger userLogger = LogManager.getLogger(FindByFIO.class);

    @Override
    public String execute(String request) {
        String fio = request.substring(request.indexOf(' ') + 1);
        File file = new File("./src/main/resources/data/generatedData.txt");
        String response = "Search did not return any result";

        ServiceFactory factory = ServiceFactory.getInstance();
        FindDataService findDataService = factory.getFindDataService();
        Optional<Client> client;
        try {
            client = findDataService.findByFIO(file, fio);
            if (client.isPresent()) {
                response = client.get().toString();
            }
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return response;
    }
}
