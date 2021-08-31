package by.training.multithreading.service.impl;

import by.training.multithreading.bean.ThreadValues;
import by.training.multithreading.dao.DaoException;
import by.training.multithreading.dao.DaoFactory;
import by.training.multithreading.dao.ThreadValuesDao;
import by.training.multithreading.service.ServiceException;
import by.training.multithreading.service.ThreadValuesCreatorService;

import java.io.File;

public class ThreadValuesCreatorServiceImpl implements ThreadValuesCreatorService {
    @Override
    public void createFromFile(int size, File f) throws ServiceException {
        if (size <= 0) {
            throw new ServiceException("Can't create array of thread values! Array size is 0 or negative value.");
        }
        if (f == null) {
            throw new ServiceException("The file does not exist or the path is specified incorrectly!");
        }
        ThreadValues values = ThreadValues.getInstance(size);
        DaoFactory daoFactory = DaoFactory.getInstance();
        ThreadValuesDao threadValuesDao = daoFactory.getThreadValuesDao();
        try {
            threadValuesDao.createFromFile(values, f);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }
}
