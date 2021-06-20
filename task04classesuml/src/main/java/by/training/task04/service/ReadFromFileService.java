package by.training.task04.service;

import by.training.task04.bean.Bank;

import java.io.File;
import java.util.Optional;

public interface ReadFromFileService {
    /**
     * Method read data from file
     *
     * @param file from which data is read
     * @return object of {@code Bank} with data
     * @throws ServiceException
     */
    Optional<Bank> readData(File file) throws ServiceException;
}
