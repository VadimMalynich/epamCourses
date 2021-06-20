package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.DAOFactory;
import by.training.task04.dao.ReadFromFile;
import by.training.task04.service.CalcAccountsAmountService;
import by.training.task04.service.ServiceException;

import java.io.File;
import java.util.Optional;

public class CalcAccountsAmountServiceImpl implements CalcAccountsAmountService {
    private static final String EXCEPTION_MESSAGE = "Invalid file path for read data!";
    private static final String PATH_START = ".\\src\\main\\resources\\data\\";

    @Override
    public double calcAllAccountsAmount(File file) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        double accountsAmount = 0;
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    accountsAmount += accounts.getAccountAmount();
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return accountsAmount;
    }

    @Override
    public double calcNegativeAccountsAmount(File file) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        double accountsAmount = 0;
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    if (accounts.getAccountAmount() < 0) {
                        accountsAmount += accounts.getAccountAmount();
                    }
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return accountsAmount;
    }

    @Override
    public double calcPositiveAccountsAmount(File file) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        double accountsAmount = 0;
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    if (accounts.getAccountAmount() > 0) {
                        accountsAmount += accounts.getAccountAmount();
                    }
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return accountsAmount;
    }
}
