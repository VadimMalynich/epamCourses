package by.training.decomposition.controller.command.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.controller.command.Command;
import by.training.decomposition.service.FilesOperationsArrayService;
import by.training.decomposition.service.ServiceException;
import by.training.decomposition.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class CreateArray {
    private static final Logger logger = LogManager.getLogger(CreateArray.class);

    public static Array createArray(int size) {
        String response = "Data from file load successful";
        Array array = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FilesOperationsArrayService arrayService = serviceFactory.getFilesOperationsArrayService();
        String dir = "./src/main/resources/creatingfiles";
        String fileName = "array.txt";
        File file = new File(dir, fileName);
        try {
            array = new Array(size);
            arrayService.createFromFile(array, file);
        } catch (ServiceException e) {
            logger.error(e);
            logger.info("Data from file is not loaded");
        } catch (Exception ex) {
            logger.fatal(ex);
            logger.info("Data from file is not loaded");
        }
        logger.info(response);
        return array;
    }
}
