package by.training.multithreading.service;

import by.training.multithreading.service.impl.FillingDiagonalByCyclicBarrier;
import by.training.multithreading.service.impl.FillingDiagonalByLock;
import by.training.multithreading.service.impl.MatrixCreatorServiceImpl;
import by.training.multithreading.service.impl.ThreadValuesCreatorServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    private final MatrixCreatorService matrixCreatorService = new MatrixCreatorServiceImpl();
    private final ThreadValuesCreatorService threadValuesCreatorService = new ThreadValuesCreatorServiceImpl();
    private final FillingMatrixDiagonalService fillingByLock = new FillingDiagonalByLock();
    private final FillingMatrixDiagonalService fillingByCyclicBarrier = new FillingDiagonalByCyclicBarrier();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MatrixCreatorService getMatrixCreatorService() {
        return matrixCreatorService;
    }

    public ThreadValuesCreatorService getThreadValuesCreatorService() {
        return threadValuesCreatorService;
    }

    public FillingMatrixDiagonalService getFillingByLock() {
        return fillingByLock;
    }

    public FillingMatrixDiagonalService getFillingByCyclicBarrier() {
        return fillingByCyclicBarrier;
    }
}
