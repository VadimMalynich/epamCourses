package by.training.multithreading.dao;

import by.training.multithreading.dao.impl.MatrixCreatorDao;
import by.training.multithreading.dao.impl.ThreadValuesCreatorDao;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final MatrixDao matrixDao = new MatrixCreatorDao();
    private final ThreadValuesDao threadValuesDao = new ThreadValuesCreatorDao();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public MatrixDao getMatrixDao() {
        return matrixDao;
    }

    public ThreadValuesDao getThreadValuesDao() {
        return threadValuesDao;
    }
}
