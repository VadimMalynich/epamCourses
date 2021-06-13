package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.dao.ArrayDAO;
import by.training.decomposition.dao.DAOException;
import by.training.decomposition.dao.DAOFactory;
import by.training.decomposition.service.FilesOperationsArrayService;
import by.training.decomposition.service.ServiceException;

import java.io.File;

public class FilesOperationsArrayServiceImpl implements FilesOperationsArrayService {
    @Override
    public void createFromFile(Array array, File f) throws ServiceException {
        if (array == null) {
            throw new ServiceException("Can't create array from file. Array does not exist!");
        }
        if (array.getLength() <= 0) {
            throw new ServiceException("Array has wrong size for creating from file!");
        }
        String path = f.getPath();
        if (!path.startsWith(".\\src\\main\\resources\\creatingfiles")) {
            throw new ServiceException("Invalid file path for creating array!");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        ArrayDAO arrayDAO = daoFactory.getArrayDAO();
        try {
            arrayDAO.createFromFile(array, f);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public String writeSortingResults(Array array, File f) throws ServiceException {
        if (array == null) {
            throw new ServiceException("Can't write array to file. Array does not exist!");
        }
        if (array.getLength() <= 0) {
            throw new ServiceException("Array has wrong size for writing to file!");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        ArrayDAO arrayDAO = daoFactory.getArrayDAO();
        String path = null;
        try {
            path = arrayDAO.writeSortingResults(array, f);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
