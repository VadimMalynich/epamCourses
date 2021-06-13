package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.service.ArraySortingService;
import by.training.decomposition.service.ServiceException;

/**
 * Class for sorting an array using sorting by selection (simple selection method)
 */
public class SimpleSelectionSort implements ArraySortingService {
    @Override
    public void sort(Array array, boolean isIncreasing) throws ServiceException {
        if (array == null) {
            throw new ServiceException("Cannot be sorted by simple selection. The array doesn't exist!");
        }
        int length = array.getLength();
        if (length <= 1) {
            throw new ServiceException("Array size is less or equal 1. Insertion sorting impossible to apply");
        }
        if (isIncreasing) {
            for (int i = 0; i < length - 1; i++) {
                int nom = i;
                for (int j = i; j < length; j++) {
                    if (array.getValue(j) < array.getValue(nom)) {
                        nom = j;
                    }
                }
                array.swap(i, nom);
            }
        } else {
            for (int i = 0; i < length - 1; i++) {
                int nom = i;
                for (int j = i; j < length; j++) {
                    if (array.getValue(j) > array.getValue(nom)) {
                        nom = j;
                    }
                }
                array.swap(i, nom);
            }
        }
    }
}
