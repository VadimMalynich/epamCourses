package by.training.decomposition.service;

import by.training.decomposition.bean.Matrix;

public interface MatrixOperationsService {
    /**
     * Method for calculating the product between matrix and value
     *
     * @param matrix
     * @param k      value
     * @return result of multiply value on matrix
     * @throws ServiceException
     */
    Matrix multiply(Matrix matrix, int k) throws ServiceException;

    /**
     * Method for calculating the product between two matrices
     *
     * @param p first matrix
     * @param q second matrix
     * @return result of multiply of first and second matrices
     * @throws ServiceException
     */
    Matrix multiply(Matrix p, Matrix q) throws ServiceException;

    /**
     * @param p    first matrix
     * @param q    second matrix
     * @param flag boolean value
     * @return result of sum between matrices if {@code true} or result of difference between matrices if {@code false}
     * @throws ServiceException
     */
    Matrix sumOrDiff(Matrix p, Matrix q, boolean flag) throws ServiceException;

    /**
     * Method for transpose matrix
     *
     * @param matrix
     * @return transposed matrix
     * @throws ServiceException
     */
    Matrix transposeMatrix(Matrix matrix) throws ServiceException;
}
