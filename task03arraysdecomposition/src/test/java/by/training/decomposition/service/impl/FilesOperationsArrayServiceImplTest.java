package by.training.decomposition.service.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.bean.Matrix;
import by.training.decomposition.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class FilesOperationsArrayServiceImplTest {
    FilesOperationsArrayServiceImpl filesOperationsArrayService = new FilesOperationsArrayServiceImpl();

    @DataProvider(name = "testCreateFromFileProvider")
    public Object[][] createDataForFillMatrixFromFileNegativePath() {
        return new Object[][]{
                {new Object[]{new Array(5), "./src/main/resources/creatingfiles/matrix"}, new int[]{0}},
                {new Object[]{new Array(3), "./src/main/resources/crеatingfiles/testMatrix.txt"}, new int[]{0}},
                {new Object[]{new Array(4), "./src/main/res0urces/creatingfiles/testMatrix.txt"}, new int[]{0}},
        };
    }

    @Test(description = "Negative scenario of filling an array from a file caused by an incorrect file path!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for creating array!",
            dataProvider = "testCreateFromFileProvider")
    public void testCreateFromFile(Object[] obj, int[] res) throws ServiceException {
        Array actual = (Array) obj[0];
        File file = new File((String) obj[1]);
        Array result = new Array(res);
        filesOperationsArrayService.createFromFile(actual, file);
        assertEquals(actual, result);
    }
}