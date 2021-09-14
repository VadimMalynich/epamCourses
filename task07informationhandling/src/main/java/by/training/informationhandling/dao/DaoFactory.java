package by.training.informationhandling.dao;


import by.training.informationhandling.dao.impl.FileReadDataDao;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final ReadDataDao readDataDao = new FileReadDataDao();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public ReadDataDao getReadDataDao() {
        return readDataDao;
    }
}
