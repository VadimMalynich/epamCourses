package by.training.multithreading.service;

import java.io.File;

public interface MatrixCreatorService {

    /**
     * Method for filling matrix with data from file {@code f}
     *
     * @param size of matrix that will be created
     * @param f    file from which we will take data
     * @throws ServiceException
     */
    void createFromFile(int size, File f) throws ServiceException;
}
