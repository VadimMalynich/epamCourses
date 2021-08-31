package by.training.multithreading.dao;

import by.training.multithreading.bean.ThreadValues;

import java.io.File;

public interface ThreadValuesDao {
    /**
     * Method for filling {@code values} with data from file {@code f}
     *
     * @param values object of {@code ThreadValues} that will be filling by values from file
     * @param f      file from which we will take data
     * @throws DaoException
     */
    void createFromFile(ThreadValues values, File f) throws DaoException;
}
