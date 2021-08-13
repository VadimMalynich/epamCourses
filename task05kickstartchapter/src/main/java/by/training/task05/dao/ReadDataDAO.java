package by.training.task05.dao;

import java.io.File;
import java.util.List;

public interface ReadDataDAO {
    /**
     * Class that read all data that will be contained in file
     *
     * @param file from that will be read data
     * @return {@code List} of strings with data
     * @throws DAOException
     */
    List<String> readData(File file) throws DAOException;
}
