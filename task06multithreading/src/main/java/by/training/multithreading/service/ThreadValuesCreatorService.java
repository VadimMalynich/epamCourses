package by.training.multithreading.service;

import java.io.File;

public interface ThreadValuesCreatorService {
    /**
     * Method for filling thread values array with data from file {@code f}
     *
     * @param size of thread values array that will be created
     * @param f    file from which we will take data
     * @throws ServiceException
     */
    void createFromFile(int size, File f) throws ServiceException;
}
