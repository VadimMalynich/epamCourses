package by.training.decomposition.dao.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.dao.DAOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class MatrixCreatorDAOTest {
    private MatrixCreatorDAO matrixCreatorDAO = new MatrixCreatorDAO();

    @DataProvider(name = "testCreateFromFilePositiveProvider")
    public Object[][] createDataForForFillMatrixFromFilePositive() {
        return new Object[][]{
                {new int[]{4, 2}, new int[][]{{14, 15}, {12, 3}, {-5, 9}, {-22, -8}}},
                {new int[]{2, 2}, new int[][]{{14, 15}, {12, 3}}},
                {new int[]{1, 10}, new int[][]{{14, 15, 12, 3, -5, 9, -22, -8, 5555, 1420}}},
                {new int[]{1, 1}, new int[][]{{14}}},
                {new int[]{12, 1}, new int[][]{{14}, {15}, {12}, {3}, {-5}, {9}, {-22}, {-8}, {5555}, {1420}, {-55548}, {52}}},
        };
    }

    @DataProvider(name = "testCreateFromFileNegativeProvider")
    public Object[][] createDataForForFillMatrixFromFileNegative() {
        return new Object[][]{
                {new int[]{10, 2}, new int[][]{{14, 15}, {12, 3}, {-5, 9}, {-22, -8}}},
                {new int[]{2, 15}, new int[][]{{14, 15}, {12, 3}}},
                {new int[]{1, 15}, new int[][]{{14, 15, 12, 3, -5, 9, -22, -8, 5555, 1420, -55548, 52, 14, 0, 2}}},
                {new int[]{15, 1}, new int[][]{{14}}},
                {new int[]{5, 5}, new int[][]{{14}, {15}, {12}, {3}, {-5}, {9}, {-22}, {-8}, {5555}, {1420}, {-55548}, {52}}},
        };
    }

    @Test(description = "Positive scenario of filling matrix from file!", dataProvider = "testCreateFromFilePositiveProvider")
    public void testCreateFromFilePositive(int[] sizes, int[][] res) throws DAOException {
        Matrix actual = new Matrix(sizes[0], sizes[1]);
        Matrix result = new Matrix(res);
        String dir = "./src/main/resources/creatingfiles";
        String path = "testMatrix.txt";
        File file = new File(dir, path);
        matrixCreatorDAO.createFromFile(actual, file);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of filling matrix from file!",
            expectedExceptions = NumberFormatException.class, dataProvider = "testCreateFromFileNegativeProvider")
    public void testCreateFromFileNegative(int[] sizes, int[][] res) throws DAOException {
        Matrix actual = new Matrix(sizes[0], sizes[1]);
        Matrix result = new Matrix(res);
        String dir = "./src/main/resources/creatingfiles";
        String path = "testMatrix.txt";
        File file = new File(dir, path);
        matrixCreatorDAO.createFromFile(actual, file);
        assertEquals(actual, result);
    }


}