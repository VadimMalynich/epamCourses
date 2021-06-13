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
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = array.getValue(l + i);
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array.getValue(m + 1 + j);
        }

        int i = 0, j = 0;
        int k = l;
        if (isIncreasing) {
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    array.setValue(L[i], k);
                    i++;
                } else {
                    array.setValue(R[j], k);
                    j++;
                }
                k++;
            }
        } else {
            while (i < n1 && j < n2) {
                if (L[i] >= R[j]) {
                    array.setValue(L[i], k);
                    i++;
                } else {
                    array.setValue(R[j], k);
                    j++;
                }
                k++;
            }
        }
        while (i < n1) {
            array.setValue(L[i], k);
            i++;
            k++;
        }
        while (j < n2) {
            array.setValue(R[j], k);
            j++;
            k++;
        }

    }
}
