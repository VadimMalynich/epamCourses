package by.training.task04.service;

import java.io.File;

public interface WorkWithStatusService {
    /**
     * Method for blocking all accounts
     *
     * @param file from which will be load data and after changes write
     * @throws ServiceException
     */
    void blockedAllAccounts(File file) throws ServiceException;

    /**
     * Method for blocking specific account
     *
     * @param file from which will be load data and after changes write
     * @param accountID ID of account that will be blocked
     * @throws ServiceException
     */
    void blockedAccount(File file, int accountID) throws ServiceException;

    /**
     * Method for activating all accounts
     *
     * @param file from which will be load data and after changes write
     * @throws ServiceException
     */
    void activateAllAccounts(File file) throws ServiceException;

    /**
     * Method for activating specific account
     *
     * @param file from which will be load data and after changes write
     * @param accountID ID of account that will be activated
     * @throws ServiceException
     */
    void activateAccount(File file, int accountID) throws ServiceException;
}
