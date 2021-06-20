package by.training.task04.controller.command.impl;

import by.training.task04.controller.command.Command;
import by.training.task04.service.ServiceException;
import by.training.task04.service.ServiceFactory;
import by.training.task04.service.WorkWithStatusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class BlockOrActiveByID implements Command {
    private static final Logger userLogger = LogManager.getLogger(BlockOrActiveByID.class);

    @Override
    public String execute(String request) {
        boolean flag = Boolean.parseBoolean(request.substring(request.indexOf('-') + 1, request.indexOf(' ')));
        int number = Integer.parseInt(request.substring(request.indexOf(' ') + 1));
        File file = new File("./src/main/resources/data/generatedData.txt");
        String response = "Blocking/activating account failed";

        ServiceFactory factory = ServiceFactory.getInstance();
        WorkWithStatusService workWithStatusService = factory.getWorkWithStatusService();

        try {
            if (flag) {
                workWithStatusService.activateAccount(file, number);
                response = "Activating account successful";
            } else {
                workWithStatusService.blockedAccount(file, number);
                response = "Blocking account successful";
            }
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return response;
    }
}
