package by.training.decomposition.controller.command.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.controller.command.Command;
import by.training.decomposition.service.FilesOperationsArrayService;
import by.training.decomposition.service.MatrixCreatorService;
import by.training.decomposition.service.ServiceException;
import by.training.decomposition.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class CreateMatrix {
    private static final Logger logger = LogManager.getLogger(CreateMatrix.class);

    public static Matrix execute(int rows, int columns, String fileName) {
        String response = "Data from file load successful";
        Matrix matrix = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixCreatorService matrixCreatorService = serviceFactory.getMatrixCreatorService();
        String dir = "./src/main/resources/creatingfiles";
        File file = new File(dir, fileName);
        try {
            matrix = new Matrix(rows, columns);
            matrixCreatorService.createFromFile(matrix, file);
        } catch (ServiceException e) {
            logger.error(e);
            logger.info("Data from file is not loaded");
        } catch (Exception ex) {
            logger.fatal(ex);
            logger.info("Data from file is not loaded");
        }
        logger.info(response);
        return matrix;
    }
}
