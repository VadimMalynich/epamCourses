package by.training.task04.service;

import java.io.File;

public interface SortAccountsService {
    /**
     * Method which sort accounts
     *
     * @param readFile file from which will be read data
     * @param writeFile file where will be write sorted data
     * @param sortField {@code String} which contains method and field of sorting
     * @throws ServiceException
     */
    void sortAccounts(File readFile, File writeFile, String sortField) throws ServiceException;
}
