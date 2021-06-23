package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.service.ArraySortingService;
import by.training.decomposition.service.ServiceException;

/**
 * Class for sorting an array using binary merge sort
 */
public class BinaryMergeSort implements ArraySortingService {
    @Override
    public void sort(Array array, boolean isIncreasing) throws ServiceException {
        if (array == null) {
            throw new ServiceException("Unable to perform binary merge sort. The array doesn't exist!");
        }
        int length = array.getLength();
        if (length <= 1) {
            throw new ServiceException("Array size is less or equal 1. Binary merge sort impossible to apply");
        }
        sortHalves(array, 0, length - 1, isIncreasing);
    }

    private void sortHalves(Array array, int l, int r, boolean isIncreasing) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sortHalves(array, l, m, isIncreasing);
            sortHalves(array, m + 1, r, isIncreasing);
            merge(array, l, m, r, isIncreasing);
        }
    }

    private void merge(Array array, int l, int m, int r, boolean isIncreasing) {
        int n1 = m - l + 1;
        int n2 = r - m;
        double left[] = new double[n1];
        double right[] = new double[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = array.getValue(l + i);
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = array.getValue(m + 1 + j);
        }

        int i = 0, j = 0;
        int k = l;
        if (isIncreasing) {
            while (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    array.setValue(left[i], k);
                    i++;
                } else {
                    array.setValue(right[j], k);
                    j++;
                }
                k++;
            }
        } else {
            while (i < n1 && j < n2) {
                if (left[i] >= right[j]) {
                    array.setValue(left[i], k);
                    i++;
                } else {
                    array.setValue(right[j], k);
                    j++;
                }
                k++;
            }
        }
        while (i < n1) {
            array.setValue(left[i], k);
            i++;
            k++;
        }
        while (j < n2) {
            array.setValue(right[j], k);
            j++;
            k++;
        }

    }
}
