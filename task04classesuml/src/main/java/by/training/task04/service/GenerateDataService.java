package by.training.task04.service;

import java.io.File;

public interface GenerateDataService {
    /**
     * Method for generating data and further writing it to a file
     *
     * @param file in that will be writing generated data
     * @throws ServiceException
     */
    void generateDate(File file) throws ServiceException;
}
