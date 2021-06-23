package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatrixOperationsServiceTest {

    @DataProvider(name = "testMultiplyPositiveProvider")
    public Object[][] createDataForMultiplyPositive() {
        return new Object[][]{
                {new Object[]{new double[][]{{1, 5, 9}, {6, 8, 2}}, new double[][]{{2, 3}, {9, 7}, {6, 0}}},
                        new double[][]{{101, 38}, {96, 74}}},

                {new Object[]{new double[][]{{5, 16}}, new double[][]{{0, 5, 7, 13}, {57, 2, 9, 4}}},
                        new double[][]{{912, 57, 179, 129}}},

                {new Object[]{new double[][]{{26, 8}}, new double[][]{{0}, {0}}}, new double[][]{{0}}},

                {new Object[]{new double[][]{{0, 0}, {5, 9}, {1, 0}}, new double[][]{{5, 4, 9}, {0, 14, 0}}},
                        new double[][]{{0, 0, 0}, {25, 146, 45}, {5, 4, 9}}},

                {new Object[]{new double[][]{{-5, 1}, {2, 6}}, new double[][]{{-6, 0, -12}, {2, -5, 14}}},
                        new double[][]{{32, -5, 74}, {0, -30, 60}}},
        };
    }

    @DataProvider(name = "testMultiplyNegativeProvider")
    public Object[][] createDataForMultiplyNegative() {
        return new Object[][]{
                {new Object[]{new double[][]{{1, 5, 9}, {6, 8, 2}}, new double[][]{{2, 3}}}, new double[][]{{0}}},
                {new Object[]{new double[][]{{5, 16}}, new double[][]{{0, 5, 7, 13}, {57, 2, 9, 4}, {548, 2, 24, 2}}}, new double[][]{{0}}},
                {new Object[]{new double[][]{{5, 8}}, new double[][]{{48, 25}, {2}, {5, 63, 20}}}, new double[][]{{0}}},
                {new Object[]{new double[][]{{0, 0}}, new double[][]{{0, 0}}}, new double[][]{{0}}},
        };
    }

    @DataProvider(name = "testTestMultiplyProvider")
    public Object[][] createDataForMultiplicationOnValue() {
        return new Object[][]{
                {new Object[]{new double[][]{{1, 5, 9}, {6, 8, 2}}, 5}, new double[][]{{5, 25, 45}, {30, 40, 10}}},
                {new Object[]{new double[][]{{5, 16}}, -4}, new double[][]{{-20, -64}}},
                {new Object[]{new double[][]{{26, 8}}, 0}, new double[][]{{0, 0}}},
                {new Object[]{new double[][]{{0, 0}, {-5, -9}, {-1, -20}}, -10}, new double[][]{{0, 0}, {50, 90}, {10, 200}}},
        };
    }

    @DataProvider(name = "testSumOrDiffPositiveProvider")
    public Object[][] createDataForSumOrDiffPositive() {
        return new Object[][]{
                {new Object[]{new double[][]{{1, 5, 9}, {6, 8, 2}}, new double[][]{{2, 3, 5}, {9, 7, 54}}, true},
                        new double[][]{{3, 8, 14}, {15, 15, 56}}},
                {new Object[]{new double[][]{{59, 21}, {19, 87}}, new double[][]{{0, 0}, {0, 0}}, true},
                        new double[][]{{59, 21}, {19, 87}}},
                {new Object[]{new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, true},
                        new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
                {new Object[]{new double[][]{{50, 0}, {0, 26}}, new double[][]{{0, 59}, {255, 0}}, true},
                        new double[][]{{50, 59}, {255, 26}}},
                {new Object[]{new double[][]{{-50, -20}, {-18, -26}}, new double[][]{{-60, -9}, {-255, -54}}, true},
                        new double[][]{{-110, -29}, {-273, -80}}},
                {new Object[]{new double[][]{{-50, -20}, {18, -26}}, new double[][]{{869, -9}, {-255, 26}}, true},
                        new double[][]{{819, -29}, {-237, 0}}},
                {new Object[]{new double[][]{{1, 5, 9}, {6, 8, 2}}, new double[][]{{2, 3, 5}, {9, 7, 54}}, false},
                        new double[][]{{-1, 2, 4}, {-3, 1, -52}}},
                {new Object[]{new double[][]{{59, 21}, {19, 87}}, new double[][]{{0, 0}, {0, 0}}, false},
                        new double[][]{{59, 21}, {19, 87}}},
                {new Object[]{new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, false},
                        new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
                {new Object[]{new double[][]{{50, 0}, {0, 26}}, new double[][]{{0, 59}, {255, 0}}, false},
                        new double[][]{{50, -59}, {-255, 26}}},
                {new Object[]{new double[][]{{-50, -20}, {-18, -26}}, new double[][]{{-60, -9}, {-255, -54}}, false},
                        new double[][]{{10, -11}, {237, 28}}},
                {new Object[]{new double[][]{{-50, -20}, {18, -26}}, new double[][]{{869, -9}, {-255, 26}}, false},
                        new double[][]{{-919, -11}, {273, -52}}},
        };
    }

    @DataProvider(name = "testSumOrDiffNegativeProvider")
    public Object[][] createDataForSumOrDiffNegative() {
        return new Object[][]{
                {new Object[]{new double[][]{{1, 5}, {6, 8, 2}}, new double[][]{{2, 3, 5}, {9, 7, 54}}, true},
                        new double[][]{{0}}},
                {new Object[]{new double[][]{{59, 21, 58}, {19, 87, 58}}, new double[][]{{0, 0}, {0, 0}}, true},
                        new double[][]{{0}}},
                {new Object[]{new double[][]{{0}}, new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, true},
                        new double[][]{{0}}},
                {new Object[]{new double[][]{{1, 5, 9}, {6, 8, 2}}, new double[][]{{0}}, false},
                        new double[][]{{-1, 2, 4}, {-3, 1, -52}}},
                {new Object[]{new double[][]{{59, 21}, {19, 87}}, new double[][]{{0, 0, 0}, {0, 0, 0}}, false},
                        new double[][]{{0}}},
                {new Object[]{new double[][]{{0, 0}, {0, 0}}, new double[][]{{0}}, false},
                        new double[][]{{0}}},
                {new Object[]{new double[][]{{50, 0, 0, 0}, {0, 0, 0, 26}}, new double[][]{{0, 59}, {255, 0}}, false},
                        new double[][]{{0}}},
                {new Object[]{new double[][]{{-50}, {-18}}, new double[][]{{-60, -9}}, false},
                        new double[][]{{0}}},
        };
    }

    @DataProvider(name = "testTransposeMatrixProvider")
    public Object[][] createDataForTransposeMatrix() {
        return new Object[][]{
                {new double[][]{{1, 5, 9}, {6, 8, 2}}, new double[][]{{1, 6}, {5, 8}, {9, 2}}},
                {new double[][]{{-10, -2, 0}, {5, -5, 5}, {-22, -23, -1}}, new double[][]{{-10, 5, -22}, {-2, -5, -23}, {0, 5, -1}}},
                {new double[][]{{0, 0, 0, 0}, {5, 6, -2, -10}}, new double[][]{{0, 5}, {0, 6}, {0, -2}, {0, -10}}},
                {new double[][]{{1, 5, 9}}, new double[][]{{1}, {5}, {9}}},
                {new double[][]{{14}, {-5}, {-92}}, new double[][]{{14, -5, -92}}},
        };
    }

    @Test(description = "Positive scenario of multiplication matrices", dataProvider = "testMultiplyPositiveProvider")
    public void testMultiplyPositive(Object obj[], double[][] res) throws ServiceException {
        Matrix p = new Matrix((double[][]) obj[0]);
        Matrix q = new Matrix((double[][]) obj[1]);
        Matrix result = new Matrix(res);
        MatrixOperationsServiceImpl matrixOperationsService = new MatrixOperationsServiceImpl();
        Matrix actual = matrixOperationsService.multiply(p, q);
        assertEquals(actual, result);
    }


    @Test(description = "Negative scenario of multiplication matrices", expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Matrices couldn't be multiplied", dataProvider = "testMultiplyNegativeProvider")
    public void testMultiplyNegative(Object obj[], double[][] res) throws ServiceException {
        Matrix p = new Matrix((double[][]) obj[0]);
        Matrix q = new Matrix((double[][]) obj[1]);
        Matrix result = new Matrix(res);
        MatrixOperationsServiceImpl matrixOperationsService = new MatrixOperationsServiceImpl();
        Matrix actual = matrixOperationsService.multiply(p, q);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of multiplication matrix on value", dataProvider = "testTestMultiplyProvider")
    public void testTestMultiply(Object obj[], double[][] res) throws ServiceException {
        Matrix matrix = new Matrix((double[][]) obj[0]);
        int k = (int) obj[1];
        Matrix result = new Matrix(res);
        MatrixOperationsServiceImpl matrixOperationsService = new MatrixOperationsServiceImpl();
        Matrix actual = matrixOperationsService.multiply(matrix, k);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of sum or difference between 2 matrices",
            dataProvider = "testSumOrDiffPositiveProvider")
    public void testSumOrDiffPositive(Object obj[], double[][] res) throws ServiceException {
        Matrix p = new Matrix((double[][]) obj[0]);
        Matrix q = new Matrix((double[][]) obj[1]);
        boolean flag = (boolean) obj[2];
        Matrix result = new Matrix(res);
        MatrixOperationsServiceImpl matrixOperationsService = new MatrixOperationsServiceImpl();
        Matrix actual = matrixOperationsService.sumOrDiff(p, q, flag);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of sum or difference between 2 matrices",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Matrices has different sizes",
            dataProvider = "testSumOrDiffNegativeProvider")
    public void testSumOrDiffNegative(Object obj[], double[][] res) throws ServiceException {
        Matrix p = new Matrix((double[][]) obj[0]);
        Matrix q = new Matrix((double[][]) obj[1]);
        boolean flag = (boolean) obj[2];
        Matrix result = new Matrix(res);
        MatrixOperationsServiceImpl matrixOperationsService = new MatrixOperationsServiceImpl();
        Matrix actual = matrixOperationsService.sumOrDiff(p, q, flag);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of transpose matrix", dataProvider = "testTransposeMatrixProvider")
    public void testTransposeMatrix(double[][] mtrx, double[][] res) throws ServiceException {
        Matrix matrix = new Matrix(mtrx);
        Matrix result = new Matrix(res);
        MatrixOperationsServiceImpl matrixOperationsService = new MatrixOperationsServiceImpl();
        Matrix actual = matrixOperationsService.transposeMatrix(matrix);
        assertEquals(actual, result);
    }
}