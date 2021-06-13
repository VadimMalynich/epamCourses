package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.service.ArraySortingService;
import by.training.decomposition.service.ServiceException;

/**
 * Class for sorting an array using exchange sort «Shaker-sort»
 */
public class ShakerSort implements ArraySortingService {
    @Override
    public void sort(Array array, boolean isIncreasing) throws ServiceException {
        if (array == null) {
            throw new ServiceException("Can't make Shaker-sort. Array does not exist!");
        }
        if (array.getLength() <= 1) {
            throw new ServiceException("Array size is less or equal 1. Shaker-sort impossible to apply");
        }
        int left = 0;
        int right = array.getLength() - 1;
        if (isIncreasing) {
            do {
                for (int i = left; i < right; i++) {
                    if (array.getValue(i) > array.getValue(i + 1)) {
                        array.swap(i, i + 1);
                    }
                }
                right--;
                for (int i = right; i > left; i--) {
                    if (array.getValue(i) < array.getValue(i - 1)) {
                        array.swap(i - 1, i);
                    }
                }
                left++;
            } while (left < right);
        } else {
            do {
                for (int i = left; i < right; i++) {
                    if (array.getValue(i) < array.getValue(i + 1)) {
                        array.swap(i, i + 1);
                    }
                }
                right--;
                for (int i = right; i > left; i--) {
                    if (array.getValue(i) > array.getValue(i - 1)) {
                        array.swap(i - 1, i);
                    }
                }
                left++;
            } while (left < right);
        }

    }
}
