package by.training.multithreading.service.impl;


import by.training.multithreading.bean.Matrix;
import by.training.multithreading.dao.DaoException;
import by.training.multithreading.dao.DaoFactory;
import by.training.multithreading.dao.MatrixDao;
import by.training.multithreading.service.MatrixCreatorService;
import by.training.multithreading.service.ServiceException;

import java.io.File;

public class MatrixCreatorServiceImpl implements MatrixCreatorService {

    @Override
    public void createFromFile(int size, File f) throws ServiceException {
        if (size <= 0) {
            throw new ServiceException("Can't create matrix! Matrix size is 0 or negative value.");
        }
        if (f == null) {
            throw new ServiceException("The file does not exist or the path is specified incorrectly!");
        }
        Matrix matrix = Matrix.getInstance(size);
        DaoFactory daoFactory = DaoFactory.getInstance();
        MatrixDao matrixDao = daoFactory.getMatrixDao();
        try {
            matrixDao.createFromFile(matrix, f);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
