package by.training.task04.dao;

import by.training.task04.bean.Bank;

import java.io.File;
import java.util.Optional;

public interface ReadFromFile {
    /**
     * Method read data from file
     *
     * @param file from which data is read
     * @return object of {@code Bank} with data
     * @throws DAOException
     */
    Optional<Bank> readData(File file) throws DAOException;
}
