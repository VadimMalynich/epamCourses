package by.training.decomposition.service;

import by.training.decomposition.bean.Array;

public interface ArraySortingService {

    /**
     * Method for sorting arrays
     *
     * @param array        that will be sort
     * @param isIncreasing boolean value of sorting. If {@code true} sorting from min to max,
     *                     {@code false} sorting from max to min
     * @throws ServiceException
     */
    void sort(Array array, boolean isIncreasing) throws ServiceException;
}
