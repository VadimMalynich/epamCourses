package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.bean.Client;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.DAOFactory;
import by.training.task04.dao.ReadFromFile;
import by.training.task04.service.FindDataService;
import by.training.task04.service.ServiceException;

import java.io.File;
import java.util.Optional;

public class FindDataServiceImpl implements FindDataService {
    private static final String EXCEPTION_MESSAGE = "Invalid file path for read data!";
    private static final String PATH_START = ".\\src\\main\\resources\\data\\";

    @Override
    public Optional<Client> findByFIO(File file, String search) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        if (search == null) {
            throw new ServiceException("Can't find user without his FIO");
        }
        String[] fio = search.split(" ");
        if (fio.length != 3) {
            throw new ServiceException("Not enough data to find a client");
        }
        Client client = new Client(0, fio[0], fio[1], fio[2]);
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    if (accounts.getClient().getSurname().equals(client.getSurname()) &&
                            accounts.getClient().getName().equals(client.getName()) &&
                            accounts.getClient().getPatronymic().equals(client.getPatronymic())) {
                        client.addBankAccount(accounts);
                    }
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return (client.getBankAccounts() == null) ? Optional.empty() : Optional.of(client);
    }

    @Override
    public Optional<BankAccount> findByAccountNumber(File file, long number) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(PATH_START)) {
            throw new ServiceException(EXCEPTION_MESSAGE);
        }
        if (1000000000000000l > number || 10000000000000000l <= number) {
            throw new ServiceException("Wrong value of account number!");
        }
        Optional<BankAccount> optionalBankAccount = null;
        DAOFactory factory = DAOFactory.getInstance();
        ReadFromFile read = factory.getReadFromFile();
        try {
            Optional<Bank> optional = read.readData(file);
            if (optional.isPresent()) {
                for (BankAccount accounts : optional.get().getBankAccounts()) {
                    if (accounts.getAccountNumber() == number) {
                        optionalBankAccount = Optional.of(accounts);
                        break;
                    }
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return optionalBankAccount;
    }
}
