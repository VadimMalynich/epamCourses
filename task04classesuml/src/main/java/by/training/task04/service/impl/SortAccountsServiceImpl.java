package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.DAOFactory;
import by.training.task04.dao.ReadFromFile;
import by.training.task04.dao.WriteToFile;
import by.training.task04.service.ServiceException;
import by.training.task04.service.SortAccountsService;

import java.io.File;
import java.util.Comparator;
import java.util.Optional;

public class SortAccountsServiceImpl implements SortAccountsService {
    @Override
    public void sortAccounts(File readFile, File writeFile, String sortField) throws ServiceException {
        String readPath = readFile.getPath();
        if (!readPath.startsWith(".\\src\\main\\resources\\data\\")) {
            throw new ServiceException("Invalid file path for read data!");
        }
        String writePath = writeFile.getPath();
        if (!writePath.startsWith(".\\src\\main\\resources\\sortedData\\")) {
            throw new ServiceException("Invalid file path for write sorted data!");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        ReadFromFile read = daoFactory.getReadFromFile();
        WriteToFile write = daoFactory.getWriteToFile();
        try {
            Optional<Bank> optional = read.readData(readFile);
            if (optional.isPresent()) {
                switch (sortField) {
                    case "number":
                        optional.get().getBankAccounts().sort(Comparator.comparing(BankAccount::getAccountNumber));
                        break;
                    case "numberReverse":
                        optional.get().getBankAccounts().sort(Comparator.comparing(BankAccount::getAccountNumber).reversed());
                        break;
                    case "amount":
                        optional.get().getBankAccounts().sort(Comparator.comparing(BankAccount::getAccountAmount));
                        break;
                    case "amountReverse":
                        optional.get().getBankAccounts().sort(Comparator.comparing(BankAccount::getAccountAmount).reversed());
                        break;
                    default:
                        throw new ServiceException("Wrong command for sort accounts!");
                }
                write.writeGenerateData(writeFile, optional.get());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
