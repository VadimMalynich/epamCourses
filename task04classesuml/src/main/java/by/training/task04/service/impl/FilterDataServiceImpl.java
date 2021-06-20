package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.DAOFactory;
import by.training.task04.dao.ReadFromFile;
import by.training.task04.dao.WriteToFile;
import by.training.task04.service.FilterDataService;
import by.training.task04.service.ServiceException;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class FilterDataServiceImpl implements FilterDataService {
    private static final String READ_PATH = ".\\src\\main\\resources\\data\\";
    private static final String WRITE_PATH = ".\\src\\main\\resources\\filteredData\\";
    private static final String WRITE_EXCEPTION_MESSAGE = "Invalid file path for write filtered data!";
    private static final String READ_EXCEPTION_MESSAGE = "Invalid file path for read data!";

    @Override
    public void filterStatus(File readFile, File writeFile, String status) throws ServiceException {
        String readPath = readFile.getPath();
        if (!readPath.startsWith(READ_PATH)) {
            throw new ServiceException(READ_EXCEPTION_MESSAGE);
        }
        String writePath = writeFile.getPath();
        if (!writePath.startsWith(WRITE_PATH)) {
            throw new ServiceException(WRITE_EXCEPTION_MESSAGE);
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        ReadFromFile read = daoFactory.getReadFromFile();
        WriteToFile write = daoFactory.getWriteToFile();
        try {
            Optional<Bank> optional = read.readData(readFile);
            Bank bank = new Bank(optional.get().getTitle(), optional.get().getBankAccounts());
            if (optional.isPresent()) {
                for (BankAccount b : optional.get().getBankAccounts()) {
                    if (!b.getAccountStatus().equals(status)) {
                        bank.deleteBankAccount(b);
                    }
                }
                optional = Optional.of(bank);
                write.writeGenerateData(writeFile, optional.get());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void filterAmount(File readFile, File writeFile, double min, double max) throws ServiceException {
        String readPath = readFile.getPath();
        if (!readPath.startsWith(READ_PATH)) {
            throw new ServiceException(READ_EXCEPTION_MESSAGE);
        }
        String writePath = writeFile.getPath();
        if (!writePath.startsWith(WRITE_PATH)) {
            throw new ServiceException(WRITE_EXCEPTION_MESSAGE);
        }
        if (min > max) {
            throw new ServiceException("Wrong data for filter accounts amount!");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        ReadFromFile read = daoFactory.getReadFromFile();
        WriteToFile write = daoFactory.getWriteToFile();
        try {
            Optional<Bank> optional = read.readData(readFile);

            if (optional.isPresent()) {
                Bank bank = new Bank(optional.get().getTitle(), optional.get().getBankAccounts());
                for (BankAccount b : bank.getBankAccounts()) {
                    if (min > b.getAccountAmount() || b.getAccountAmount() > max) {
                        optional.get().deleteBankAccount(b);
                    }
                }
                write.writeGenerateData(writeFile, optional.get());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
