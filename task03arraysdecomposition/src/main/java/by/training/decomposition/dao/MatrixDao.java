package by.training.decomposition.dao;

import by.training.decomposition.bean.Matrix;

import java.io.File;

public interface MatrixDao {
    /**
     * Method for filling matrix random values
     *
     * @param matrix
     * @param minValue min value for filling matrix
     * @param maxValue max value for filling matrix
     * @throws DAOException
     */
    void fillRandomized(Matrix matrix, int minValue, int maxValue) throws DAOException;

    /**
     * Method for creating array with {@code n} rows and {@code m} columns and filling random values from
     * {@code minValue} to {@code maxValue}
     *
     * @param n        number of rows
     * @param m        number of columns
     * @param minValue min value for filling matrix
     * @param maxValue max value for filling matrix
     * @return filled array
     * @throws DAOException
     */
    int[][] createArray(int n, int m, int minValue, int maxValue) throws DAOException;

    /**
     * Method for filling {@code matrix} with data from file {@code f}
     *
     * @param matrix
     * @param f      file from which we will take data
     * @throws DAOException
     */
    void createFromFile(Matrix matrix, File f) throws DAOException;
}
