package by.training.decomposition.controller.command.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.controller.command.Command;
import by.training.decomposition.service.ArraySortingService;
import by.training.decomposition.service.FilesOperationsArrayService;
import by.training.decomposition.service.ServiceException;
import by.training.decomposition.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class InsertSort implements Command {
    private static final Logger logger = LogManager.getLogger(InsertSort.class);

    @Override
    public String execute(String request) {
        request = request.trim();
        int size = Integer.parseInt(request.substring(request.indexOf('-') + 1, request.indexOf(' ')));
        boolean isIncreasing = Boolean.parseBoolean(request.substring(request.indexOf(' ') + 1));
        Array array = CreateArray.createArray(size);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ArraySortingService insertSort = serviceFactory.getInsertSort();
        FilesOperationsArrayService filesOperations = serviceFactory.getFilesOperationsArrayService();
        String response = null;
        try {
            insertSort.sort(array, isIncreasing);
            File file = new File("./src/main/resources/sortingresults/insertResult.txt");
            response = filesOperations.writeSortingResults(array, file);
        } catch (ServiceException e) {
            logger.warn(e);
        }
        return response;
    }
}
