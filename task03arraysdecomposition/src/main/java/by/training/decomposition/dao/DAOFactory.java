package by.training.decomposition.dao;

import by.training.decomposition.dao.impl.FilesOperationsArrayDAO;
import by.training.decomposition.dao.impl.MatrixCreatorDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final MatrixDao matrixDao = new MatrixCreatorDAO();
    private final ArrayDAO arrayDAO = new FilesOperationsArrayDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public MatrixDao getMatrixDao() {
        return matrixDao;
    }

    public ArrayDAO getArrayDAO() {
        return arrayDAO;
    }
}
