package by.training.task04.dao;

import by.training.task04.dao.impl.ReadDataDAO;
import by.training.task04.dao.impl.WriteToFileDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    WriteToFile writeToFile = new WriteToFileDAO();
    ReadFromFile readFromFile = new ReadDataDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public WriteToFile getWriteToFile() {
        return writeToFile;
    }

    public ReadFromFile getReadFromFile() {
        return readFromFile;
    }
}
