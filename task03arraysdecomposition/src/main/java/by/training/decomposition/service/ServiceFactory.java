package by.training.decomposition.service;

import by.training.decomposition.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    private final MatrixCreatorService matrixCreatorService = new MatrixCreatorServiceImpl();
    private final FilesOperationsArrayService filesOperationsArrayService = new FilesOperationsArrayServiceImpl();
    private final MatrixOperationsService matrixOperationsService = new MatrixOperationsServiceImpl();
    private final ArraySortingService binaryMergeSort = new BinaryMergeSort();
    private final ArraySortingService bubbleSort = new BubbleSort();
    private final ArraySortingService insertSort = new InsertSort();
    private final ArraySortingService shakerSort = new ShakerSort();
    private final ArraySortingService shellSort = new ShellSort();
    private final ArraySortingService simpleSelectionSort = new SimpleSelectionSort();


    public static ServiceFactory getInstance() {
        return instance;
    }

    public MatrixCreatorService getMatrixCreatorService() {
        return matrixCreatorService;
    }

    public FilesOperationsArrayService getFilesOperationsArrayService() {
        return filesOperationsArrayService;
    }

    public MatrixOperationsService getMatrixOperationsService() {
        return matrixOperationsService;
    }

    public ArraySortingService getBinaryMergeSort() {
        return binaryMergeSort;
    }

    public ArraySortingService getBubbleSort() {
        return bubbleSort;
    }

    public ArraySortingService getInsertSort() {
        return insertSort;
    }

    public ArraySortingService getShakerSort() {
        return shakerSort;
    }

    public ArraySortingService getShellSort() {
        return shellSort;
    }

    public ArraySortingService getSimpleSelectionSort() {
        return simpleSelectionSort;
    }
}
