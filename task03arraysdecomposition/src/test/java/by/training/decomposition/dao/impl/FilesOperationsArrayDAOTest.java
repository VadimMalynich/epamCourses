package by.training.decomposition.dao.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.bean.Matrix;
import by.training.decomposition.dao.DAOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class FilesOperationsArrayDAOTest {

    FilesOperationsArrayDAO filesOperationsArrayDAO = new FilesOperationsArrayDAO();

    @DataProvider(name = "testCreateFromFilePositiveProvider")
    public Object[][] createDataForForFillArrayFromFilePositive() {
        return new Object[][]{
                {4, new int[]{20, -554, 854, -54}},
                {1, new int[]{20}},
                {10, new int[]{20, -554, 854, -54, 55, 55, 87, 36, -655, -4}},
                {14, new int[]{20, -554, 854, -54, 55, 55, 87, 36, -655, -4, 5, 88, -6, 99}},
        };
    }

    @DataProvider(name = "testCreateFromFileNegativeProvider")
    public Object[][] createDataForForFillArrayFromFileNegative() {
        return new Object[][]{
                {15, new int[]{20, -554, 854, -54, 55, 55, 87, 36, -655, -4, 5, 88, -6, 99, 4554}},
                {120, new int[]{20, -554, 854, -54, 55, 55, 87}},
        };
    }

    @Test(description = "Positive scenario of filling array from file!", dataProvider = "testCreateFromFilePositiveProvider")
    public void testCreateFromFilePositive(int size, int[] res) throws DAOException {
        Array actual = new Array(size);
        Array result = new Array(res);
        String dir = "./src/main/resources/creatingfiles";
        String path = "testArray.txt";
        File file = new File(dir, path);
        filesOperationsArrayDAO.createFromFile(actual, file);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of filling array from file!", expectedExceptions = NumberFormatException.class,
            dataProvider = "testCreateFromFileNegativeProvider")
    public void testCreateFromFileNegative(int size, int[] res) throws DAOException {
        Array actual = new Array(size);
        Array result = new Array(res);
        String dir = "./src/main/resources/creatingfiles";
        String path = "testArray.txt";
        File file = new File(dir, path);
        filesOperationsArrayDAO.createFromFile(actual, file);
        assertEquals(actual, result);
    }

}