package by.training.task04.service.impl;

import by.training.task04.bean.AccountStatus;
import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.DAOFactory;
import by.training.task04.dao.ReadFromFile;
import by.training.task04.dao.WriteToFile;
import by.training.task04.service.ServiceException;
import by.training.task04.service.WorkWithStatusService;

import java.io.File;
import java.util.Optional;

public class WorkWithStatusServiceImpl implements WorkWithStatusService {
    private static final String EXCEPTION_MESSAGE = "Invalid file path for read data!";
    private static final String PATH_START = ".\\src\\main\\resources\\data\\";
    private static final String INDEX_EXCEPTION = "Index for change status should be > 0!";

    @Override
    public void blockedAllAccounts(File file) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        WriteToFile write = factory.getWriteToFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    if (AccountStatus.ACTIVE.getValue().equals(accounts.getAccountStatus())) {
                        accounts.setAccountStatus(AccountStatus.BLOCKED.getValue());
                    }
                }
                write.writeGenerateData(file, optional.get());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void blockedAccount(File file, int accountID) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        if (accountID <= 0) {
            throw new ServiceException(INDEX_EXCEPTION);
        }
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        WriteToFile write = factory.getWriteToFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    if (accounts.getClient().getId() == accountID) {
                        accounts.setAccountStatus(AccountStatus.BLOCKED.getValue());
                        break;
                    }
                }
                write.writeGenerateData(file, optional.get());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void activateAllAccounts(File file) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        WriteToFile write = factory.getWriteToFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    if (AccountStatus.BLOCKED.getValue().equals(accounts.getAccountStatus())) {
                        accounts.setAccountStatus(AccountStatus.ACTIVE.getValue());
                    }
                }
                write.writeGenerateData(file, optional.get());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void activateAccount(File file, int accountID) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        if (accountID <= 0) {
            throw new ServiceException(INDEX_EXCEPTION);
        }
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        WriteToFile write = factory.getWriteToFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    if (accounts.getClient().getId() == accountID) {
                        accounts.setAccountStatus(AccountStatus.ACTIVE.getValue());
                        break;
                    }
                }
                write.writeGenerateData(file, optional.get());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
