package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.service.MatrixOperationsService;
import by.training.decomposition.service.ServiceException;

public class MatrixOperationsServiceImpl implements MatrixOperationsService {
    @Override
    public Matrix multiply(Matrix matrix, int k) throws ServiceException {
        int rows = matrix.getVerticalSize();
        int columns = matrix.getHorizontalSize();
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                checkRange(result, i, j);
                checkRange(matrix, i, j);
                result.setElement(i, j, (matrix.getElement(i, j) * k));
            }
        }
        return result;
    }

    @Override
    public Matrix multiply(Matrix p, Matrix q) throws ServiceException {
        int v = p.getVerticalSize();
        int h = q.getHorizontalSize();
        int controlSize = p.getHorizontalSize();
        if (controlSize != q.getVerticalSize()) {
            throw new ServiceException("Matrices couldn't be multiplied");
        }
        Matrix result = new Matrix(v, h);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                int value = 0;
                for (int k = 0; k < controlSize; k++) {
                    checkRange(p, i, j);
                    checkRange(q, i, j);
                    value += p.getElement(i, k) * q.getElement(k, j);
                }
                checkRange(result, i, j);
                result.setElement(i, j, value);
            }
        }
        return result;
    }

    @Override
    public Matrix sumOrDiff(Matrix p, Matrix q, boolean flag) throws ServiceException {
        int pRows = p.getVerticalSize();
        int pColumns = p.getHorizontalSize();
        int qRows = q.getVerticalSize();
        int qColumns = q.getHorizontalSize();
        if (pRows != qRows || pColumns != qColumns) {
            throw new ServiceException("Matrices has different sizes");
        }
        Matrix result = new Matrix(pRows, pColumns);
        if (flag) {
            for (int i = 0; i < pRows; i++) {
                for (int j = 0; j < pColumns; j++) {
                    checkRange(p, i, j);
                    checkRange(q, i, j);
                    double value = p.getElement(i, j) + q.getElement(i, j);
                    checkRange(result, i, j);
                    result.setElement(i, j, value);
                }
            }
        } else {
            for (int i = 0; i < pRows; i++) {
                for (int j = 0; j < pColumns; j++) {
                    checkRange(p, i, j);
                    checkRange(q, i, j);
                    double value = p.getElement(i, j) - q.getElement(i, j);
                    checkRange(result, i, j);
                    result.setElement(i, j, value);
                }
            }
        }
        return result;
    }

    @Override
    public Matrix transposeMatrix(Matrix matrix) throws ServiceException {
        int rows = matrix.getVerticalSize();
        int columns = matrix.getHorizontalSize();
        Matrix result = new Matrix(columns, rows);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                checkRange(matrix, i, j);
                double value = matrix.getElement(j, i);
                checkRange(result, i, j);
                result.setElement(i, j, value);
            }
        }
        return result;
    }

    private void checkRange(Matrix mtrx, int i, int j) throws ServiceException {
        if (i < 0 && i > mtrx.getVerticalSize() && j < 0 && j > mtrx.getHorizontalSize()) {
            throw new ServiceException("Out of matrix range!");
        }
    }
}
