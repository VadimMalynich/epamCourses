package by.training.decomposition.dao;

import by.training.decomposition.bean.Array;

import java.io.File;

public interface ArrayDAO {
    /**
     * Method for filling array from file
     *
     * @param array that will be fill in
     * @param f     file from which will take data
     * @throws DAOException
     */
    void createFromFile(Array array, File f) throws DAOException;

    /**
     * Method for writing sorted array in file
     *
     * @param array that will be write in file
     * @param f     file in which will write {@code array}
     * @return string of path file
     * @throws DAOException
     */
    String writeSortingResults(Array array, File f) throws DAOException;
}
