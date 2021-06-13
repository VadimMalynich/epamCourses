package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.service.ArraySortingService;
import by.training.decomposition.service.ServiceException;

/**
 * Class for sorting an array using Shell sort (descending sort)
 */
public class ShellSort implements ArraySortingService {
    @Override
    public void sort(Array array, boolean isIncreasing) throws ServiceException {
        if (array == null) {
            throw new ServiceException("Shell sort fails. The array doesn't exist!");
        }
        int length = array.getLength();
        if (length <= 1) {
            throw new ServiceException("Array size is less or equal 1. Shell sort impossible to apply");
        }
        if (isIncreasing) {
            for (int step = length / 2; step > 0; step /= 2) {
                for (int i = step; i < length; i++) {
                    for (int j = i - step; j >= 0 && array.getValue(j) > array.getValue(j + step); j -= step) {
                        if (array.getValue(j) > array.getValue(j + step)) {
                            array.swap(j, j + step);
                        }
                    }
                }
            }
        } else {
            for (int step = length / 2; step > 0; step /= 2) {
                for (int i = step; i < length; i++) {
                    for (int j = i - step; j >= 0 && array.getValue(j) < array.getValue(j + step); j -= step) {
                        if (array.getValue(j) < array.getValue(j + step)) {
                            array.swap(j, j + step);
                        }
                    }
                }
            }
        }

    }
}
