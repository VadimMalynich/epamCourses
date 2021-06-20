package by.training.task04.service;

import java.io.File;

public interface CalcAccountsAmountService {
    /**
     * Method calculate amounts for all accounts
     *
     * @param file from which will be load data
     * @return sum of all accounts amount
     * @throws ServiceException
     */
    double calcAllAccountsAmount(File file) throws ServiceException;

    /**
     * Method calculate amounts for all accounts that have negative amount
     *
     * @param file from which will be load data
     * @return sum of all negative accounts amount
     * @throws ServiceException
     */
    double calcNegativeAccountsAmount(File file) throws ServiceException;

    /**
     * Method calculate amounts for all accounts that have positive amount
     *
     * @param file from which will be load data
     * @return sum of all negative accounts amount
     * @throws ServiceException
     */
    double calcPositiveAccountsAmount(File file) throws ServiceException;
}
