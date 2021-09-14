package by.training.informationhandling.dao;

import java.io.File;

public interface ReadDataDao {
    /**
     * Class that read all data that will be contained in file
     *
     * @param file from that will be read data
     * @return {@code List} of strings with data
     * @throws DaoException
     */
    String readData(File file) throws DaoException;
}
