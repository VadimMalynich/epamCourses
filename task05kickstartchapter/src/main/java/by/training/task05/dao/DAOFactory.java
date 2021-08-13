package by.training.task05.dao;


import by.training.task05.dao.impl.FileReadDataDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    private final ReadDataDAO readDataDAO = new FileReadDataDAO();

    public static DAOFactory getInstance() {
        return instance;
    }

    public ReadDataDAO getReadDataDAO() {
        return readDataDAO;
    }
}
