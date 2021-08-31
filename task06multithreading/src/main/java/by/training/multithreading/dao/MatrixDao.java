package by.training.multithreading.dao;


import by.training.multithreading.bean.Matrix;

import java.io.File;

public interface MatrixDao {
    /**
     * Method for filling {@code matrix} with data from file {@code f}
     *
     * @param matrix object of {@code Matrix} that will be filling by values from file
     * @param f      file from which we will take data
     * @throws DaoException
     */
    void createFromFile(Matrix matrix, File f) throws DaoException;
}
