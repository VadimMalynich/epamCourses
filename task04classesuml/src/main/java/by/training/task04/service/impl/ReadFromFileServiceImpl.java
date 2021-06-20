package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.DAOFactory;
import by.training.task04.dao.ReadFromFile;
import by.training.task04.service.ReadFromFileService;
import by.training.task04.service.ServiceException;

import java.io.File;
import java.util.Optional;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public Optional<Bank> readData(File file) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(".\\src\\main\\resources\\data\\")) {
            throw new ServiceException("Invalid file path for read data!");
        }
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();

        Optional<Bank> bank;
        try {
            bank = read.readData(file);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return bank;
    }
}
