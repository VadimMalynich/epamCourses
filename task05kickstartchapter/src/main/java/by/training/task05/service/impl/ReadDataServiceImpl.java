package by.training.task05.service.impl;

import by.training.task05.dao.DAOException;
import by.training.task05.dao.DAOFactory;
import by.training.task05.dao.ReadDataDAO;
import by.training.task05.service.ReadDataService;
import by.training.task05.service.ServiceException;

import java.io.File;
import java.util.List;

public class ReadDataServiceImpl implements ReadDataService {
    @Override
    public List<String> readData(File file) throws ServiceException {
        if(!file.isFile()){
            throw new ServiceException("File doesn't exist!");
        }
        List<String> lines;
        DAOFactory factory = DAOFactory.getInstance();
        ReadDataDAO readDataDAO = factory.getReadDataDAO();
        try {
            lines = readDataDAO.readData(file);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return lines;
    }
}
