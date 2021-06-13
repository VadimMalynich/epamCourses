package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.service.ArraySortingService;
import by.training.decomposition.service.ServiceException;

/**
 * Class for sorting an array using insertion sort (simple insertion method)
 */
public class InsertSort implements ArraySortingService {
    @Override
    public void sort(Array array, boolean isIncreasing) throws ServiceException {
        if (array == null) {
            throw new ServiceException("Can't sort by inserts. Array does not exist!");
        }
        int length = array.getLength();
        if (length <= 1) {
            throw new ServiceException("Array size is less or equal 1. Insertion sorting impossible to apply");
        }
        if (isIncreasing) {
            for (int i = 1; i < length; i++) {
                int j = i;
                while (j > 0 && array.getValue(j) < array.getValue(j - 1)) {
                    array.swap(j, j - 1);
                    j--;
                }
            }
        } else {
            for (int i = 1; i < length; i++) {
                int j = i;
                while (j > 0 && array.getValue(j) > array.getValue(j - 1)) {
                    array.swap(j, j - 1);
                    j--;
                }
            }
        }

    }
}
