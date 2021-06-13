package by.training.decomposition.controller.command.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.controller.command.Command;
import by.training.decomposition.service.MatrixOperationsService;
import by.training.decomposition.service.ServiceException;
import by.training.decomposition.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiplyMatrixOnValue implements Command {
    private static final Logger logger = LogManager.getLogger(MultiplyMatrixOnValue.class);

    @Override
    public String execute(String request) {
        request = request.trim();
        int rows = Integer.parseInt(request.substring(request.indexOf('-') + 1, request.indexOf(' ')));
        int columns = Integer.parseInt(request.substring(request.indexOf(' ') + 1, request.lastIndexOf(' ')));
        int value = Integer.parseInt(request.substring(request.lastIndexOf(' ') + 1));
        Matrix matrix = CreateMatrix.execute(rows, columns, "matrixP.txt");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperationsService matrixOperationsService = serviceFactory.getMatrixOperationsService();

        try {
            matrix = matrixOperationsService.multiply(matrix, value);
        } catch (ServiceException e) {
            logger.warn(e);
        }
        return matrix.toString();
    }
}
