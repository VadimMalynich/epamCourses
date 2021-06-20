package by.training.task04.service;

import java.io.File;

public interface FilterDataService {
    /**
     * Method filter data by account status
     *
     * @param readFile  file from which will be read data
     * @param writeFile file where will be write sorted data
     * @param status    that will remain after filtering
     * @throws ServiceException
     */
    void filterStatus(File readFile, File writeFile, String status) throws ServiceException;

    /**
     * Method for filtering data by account amount
     *
     * @param readFile  file from which will be read data
     * @param writeFile file where will be write sorted data
     * @param min       {@code Double} lower limit for filtering
     * @param max       {@code Double} higher limit for filtering
     * @throws ServiceException
     */
    void filterAmount(File readFile, File writeFile, double min, double max) throws ServiceException;
}
