package by.training.multithreading.controller.command.impl;

import by.training.multithreading.controller.command.Command;
import by.training.multithreading.service.MatrixCreatorService;
import by.training.multithreading.service.ServiceException;
import by.training.multithreading.service.ServiceFactory;
import by.training.multithreading.service.ThreadValuesCreatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class CreateData implements Command {
    private static final Logger userLogger = LogManager.getLogger(CreateData.class);

    @Override
    public void execute(String request) {
        String data[] = request.split("-");
        int matrixSize = Integer.parseInt(data[1]);
        int threadValuesSize = Integer.parseInt(data[2]);
        File matrixFile = new File("data/matrixData.txt");
        File threadValuesFile = new File("data/threadValues.txt");

        ServiceFactory factory = ServiceFactory.getInstance();
        MatrixCreatorService matrixCreatorService = factory.getMatrixCreatorService();
        ThreadValuesCreatorService threadValuesCreatorService = factory.getThreadValuesCreatorService();

        try {
            matrixCreatorService.createFromFile(matrixSize, matrixFile);
            threadValuesCreatorService.createFromFile(threadValuesSize, threadValuesFile);
        } catch (ServiceException e) {
            userLogger.error(e);
        }

    }
}
