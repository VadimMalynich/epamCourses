package by.training.informationhandling.service.impl;

import by.training.informationhandling.dao.DaoException;
import by.training.informationhandling.dao.DaoFactory;
import by.training.informationhandling.dao.ReadDataDao;
import by.training.informationhandling.service.ReadDataService;
import by.training.informationhandling.service.ServiceException;

import java.io.File;

public class ReadDataServiceImpl implements ReadDataService {
    @Override
    public String readData(File file) throws ServiceException {
        if(!file.isFile()){
            throw new ServiceException("File doesn't exist!");
        }
        String text;
        DaoFactory factory = DaoFactory.getInstance();
        ReadDataDao readDataDAO = factory.getReadDataDao();
        try {
            text = readDataDAO.readData(file);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return text;
    }
}
