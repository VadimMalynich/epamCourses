package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class MatrixCreatorServiceImplTest {
    MatrixCreatorServiceImpl matrixCreatorService = new MatrixCreatorServiceImpl();

    @DataProvider(name = "testCreateFromFileNegativePathProvider")
    public Object[][] createDataForFillMatrixFromFileNegativePath() {
        return new Object[][]{
                {new Object[]{new Matrix(5, 8), "./src/main/resources/creatingfiles/matrix"}, new int[][]{{0}}},
                {new Object[]{new Matrix(5, 3), "./src/main/resources/crеatingfiles/testMatrix.txt"}, new int[][]{{0}}},
                {new Object[]{new Matrix(5, 4), "./src/main/res0urces/creatingfiles/testMatrix.txt"}, new int[][]{{0}}},
        };
    }

    @Test(description = "Negative scenario of filling a matrix from a file caused by an incorrect file path!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for creating matrix!",
            dataProvider = "testCreateFromFileNegativePathProvider")
    public void testCreateFromFileNegativePath(Object[] obj, int[][] res) throws ServiceException {
        Matrix actual = (Matrix) obj[0];
        Matrix result = new Matrix(res);
        File file = new File((String) obj[1]);
        matrixCreatorService.createFromFile(actual, file);
        assertEquals(actual, result);
    }
}