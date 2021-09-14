package by.training.informationhandling.controller.command.impl;

import by.training.informationhandling.controller.command.Command;
import by.training.informationhandling.service.ReadDataService;
import by.training.informationhandling.service.ServiceException;
import by.training.informationhandling.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ReadData implements Command {
    private static final Logger userLogger = LogManager.getLogger(ReadData.class);

    @Override
    public String execute(String request) {
        File file = new File("data/text.txt");
        ServiceFactory factory = ServiceFactory.getInstance();
        ReadDataService readDataService = factory.getReadDataService();
        String text = null;
        try {
             text = readDataService.readData(file);
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return text;
    }
}
