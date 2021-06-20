package by.training.task04.service;

import by.training.task04.bean.BankAccount;
import by.training.task04.bean.Client;

import java.io.File;
import java.util.Optional;

public interface FindDataService {
    /**
     * Method that find client by his FIO
     *
     * @param file   file from which will be read data
     * @param search {@code String} FIO of client that should be found
     * @return {@code Optional<Client>} info of client that was found
     * @throws ServiceException
     */
    Optional<Client> findByFIO(File file, String search) throws ServiceException;

    /**
     * Method that find bank account by account number
     *
     * @param file   file from which will be read data
     * @param number {@code Long} account number that should be found
     * @return {@code Optional<BankAccount>} info of bank account that was found
     * @throws ServiceException
     */
    Optional<BankAccount> findByAccountNumber(File file, long number) throws ServiceException;
}
