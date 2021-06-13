package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShakerSortTest {
    private ShakerSort shakerSort = new ShakerSort();

    @DataProvider(name = "testSortToHighProvider")
    public Object[][] createDataForSortToHigh() {
        return new Object[][]{
                {new int[]{201, 55, 8963, 2014, 44, 20, 3, -5, -2, -6665}, new int[]{-6665, -5, -2, 3, 20, 44, 55, 201, 2014, 8963}},
                {new int[]{9, 22, -3, 992, -5, -284, 54}, new int[]{-284, -5, -3, 9, 22, 54, 992}},
                {new int[]{-550, -542, -549, -33, -54, -26}, new int[]{-550, -549, -542, -54, -33, -26}},
                {new int[]{-95, -11, -220, -69, -2}, new int[]{-220, -95, -69, -11, -2}},
                {new int[]{0, 665, 47, 855, 693, 21, 5}, new int[]{0, 5, 21, 47, 665, 693, 855}},
                {new int[]{55, 83, 14, 0, 6, 100}, new int[]{0, 6, 14, 55, 83, 100}},
                {new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}},
        };
    }

    @DataProvider(name = "testSortToLowProvider")
    public Object[][] createDataForSortToLow() {
        return new Object[][]{
                {new int[]{201, 55, 8963, 2014, 44, 20, 3, -5, -2, -6665}, new int[]{8963, 2014, 201, 55, 44, 20, 3, -2, -5, -6665}},
                {new int[]{9, 22, -3, 992, -5, -284, 54}, new int[]{992, 54, 22, 9, -3, -5, -284}},
                {new int[]{-550, -542, -549, -33, -54, -26}, new int[]{-26, -33, -54, -542, -549, -550}},
                {new int[]{-95, -11, -220, -69, -2}, new int[]{-2, -11, -69, -95, -220}},
                {new int[]{55, 83, 14, 0, 6, 100}, new int[]{100, 83, 55, 14, 6, 0}},
                {new int[]{0, 665, 47, 855, 693, 21, 5, 77}, new int[]{855, 693, 665, 77, 47, 21, 5, 0}},
                {new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}},
        };
    }

    @DataProvider(name = "testSortArrayLengthProvider")
    public Object[][] createDataForSortArrayLengthException() {
        return new Object[][]{
                {new int[]{-5}, new int[]{-5}},
                {new int[]{}, new int[]{0}},
                {new int[]{0}, new int[]{0}},
        };
    }

    @Test(description = "Positive scenario of Shaker-sort from min to max value", dataProvider = "testSortToHighProvider")
    public void testSortToHigh(int[] arr, int[] res) throws ServiceException {
        Array actual = new Array(arr);
        Array result = new Array(res);
        shakerSort.sort(actual, true);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of Shaker-sort from max to min value", dataProvider = "testSortToLowProvider")
    public void testSortToLow(int[] arr, int[] res) throws ServiceException {
        Array actual = new Array(arr);
        Array result = new Array(res);
        shakerSort.sort(actual, false);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of Shaker-sort when array has length < 2",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Array size is less or equal 1. Shaker-sort impossible to apply",
            dataProvider = "testSortArrayLengthProvider")
    public void testSortArrayLength(int[] arr, int[] res) throws ServiceException {
        Array actual = new Array(arr);
        Array result = new Array(res);
        shakerSort.sort(actual, false);
        assertEquals(actual, result);
    }
}