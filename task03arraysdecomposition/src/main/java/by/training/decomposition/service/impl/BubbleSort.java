package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.service.ArraySortingService;
import by.training.decomposition.service.ServiceException;

/**
 * Class for sorting an array using exchange sort (bubble method)
 */
public class BubbleSort implements ArraySortingService {
    @Override
    public void sort(Array array, boolean isIncreasing) throws ServiceException {
        if (array == null) {
            throw new ServiceException("Can't make bubble sort. Array does not exist!");
        }
        int length = array.getLength();
        if (length <= 1) {
            throw new ServiceException("Array size is less or equal 1. Bubble sort impossible to apply");
        }
        if (isIncreasing) {
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - 1 - i; j++) {
                    if (array.getValue(j) > array.getValue(j + 1)) {
                        array.swap(j, j + 1);
                    }
                }
            }
        } else {
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - 1 - i; j++) {
                    if (array.getValue(j) < array.getValue(j + 1)) {
                        array.swap(j, j + 1);
                    }
                }
            }
        }

    }
}
