package by.training.task04.controller.command.impl;

import by.training.task04.controller.command.Command;
import by.training.task04.service.GenerateDataService;
import by.training.task04.service.ServiceException;
import by.training.task04.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class GenerateData implements Command {
    private static final Logger userLogger = LogManager.getLogger(GenerateData.class);

    @Override
    public String execute(String request) {
        String response = "Data generation failed";
        ServiceFactory factory = ServiceFactory.getInstance();
        GenerateDataService generateDataService = factory.getGenerateDataService();
        File file = new File("./src/main/resources/data/generatedData.txt");
        try {
            generateDataService.generateDate(file);
            response = "Data generated successful";
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return response;
    }
}
