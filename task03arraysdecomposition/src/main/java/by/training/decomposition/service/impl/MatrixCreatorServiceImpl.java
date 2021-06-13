package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.dao.DAOException;
import by.training.decomposition.dao.DAOFactory;
import by.training.decomposition.dao.MatrixDao;
import by.training.decomposition.service.MatrixCreatorService;
import by.training.decomposition.service.ServiceException;

import java.io.File;

public class MatrixCreatorServiceImpl implements MatrixCreatorService {
    @Override
    public void fillRandomized(Matrix matrix, int minValue, int maxValue) throws ServiceException {
        if (matrix == null) {
            throw new ServiceException("Can't filling matrix random values. Matrix does not exist!");
        }
        if (matrix.getHorizontalSize() <= 0 || matrix.getVerticalSize() <= 0) {
            throw new ServiceException("Matrix has wrong size for filling random values");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixDao matrixDao = daoFactory.getMatrixDao();
        try {
            matrixDao.fillRandomized(matrix, minValue, maxValue);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int[][] createArray(int n, int m, int minValue, int maxValue) throws ServiceException {
        if (n <= 0 || m <= 0) {
            throw new ServiceException("Wrong size for array creating!");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixDao matrixDao = daoFactory.getMatrixDao();
        int arr[][];
        try {
            arr = matrixDao.createArray(n, m, minValue, maxValue);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return arr;
    }

    @Override
    public void createFromFile(Matrix matrix, File f) throws ServiceException {
        if (matrix == null) {
            throw new ServiceException("Can't create matrix from file. Matrix does not exist!");
        }
        if (matrix.getHorizontalSize() <= 0 || matrix.getVerticalSize() <= 0) {
            throw new ServiceException("Matrix has wrong size for creating from file!");
        }
        String path = f.getPath();
        if (!path.startsWith(".\\src\\main\\resources\\creatingfiles")) {
            throw new ServiceException("Invalid file path for creating matrix!");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixDao matrixDao = daoFactory.getMatrixDao();
        try {
            matrixDao.createFromFile(matrix, f);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
