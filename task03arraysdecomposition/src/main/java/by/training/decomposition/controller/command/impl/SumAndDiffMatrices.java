package by.training.decomposition.controller.command.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.controller.command.Command;
import by.training.decomposition.service.MatrixOperationsService;
import by.training.decomposition.service.ServiceException;
import by.training.decomposition.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumAndDiffMatrices implements Command {
    private static final Logger logger = LogManager.getLogger(SumAndDiffMatrices.class);

    @Override
    public String execute(String request) {
        request = request.trim();
        int rows = Integer.parseInt(request.substring(request.indexOf('-') + 1, request.indexOf(' ')));
        int columns = Integer.parseInt(request.substring(request.indexOf(' ') + 1, request.indexOf(';')));
        Matrix matrixP = CreateMatrix.execute(rows, columns, "matrixP.txt");
        rows = Integer.parseInt(request.substring(request.indexOf(';') + 1, request.lastIndexOf(' ')));
        columns = Integer.parseInt(request.substring(request.lastIndexOf(' ') + 1, request.indexOf(',')));
        boolean flag = Boolean.parseBoolean(request.substring(request.indexOf(',') + 1));
        Matrix matrixQ = CreateMatrix.execute(rows, columns, "matrixQ.txt");
        Matrix result = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperationsService matrixOperationsService = serviceFactory.getMatrixOperationsService();

        try {
            result = matrixOperationsService.sumOrDiff(matrixP, matrixQ, flag);
        } catch (ServiceException e) {
            logger.warn(e);
        }
        return String.valueOf(result);
    }
}
