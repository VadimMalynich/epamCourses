package by.training.multithreading.service.impl;

import by.training.multithreading.service.ServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class MatrixCreatorServiceImplTest {
    MatrixCreatorServiceImpl creatorService = new MatrixCreatorServiceImpl();

    @DataProvider(name = "testCreateFromFileNegativeSizeProvider")
    public Object[][] createDataForFillMatrixFromFileNegativeSize() {
        return new Object[][]{
                {0, new File("data/sad.txt")},
                {-5, new File("dwsdsdwd.txt")},
                {-1000, new File("data/test.txt")}
        };
    }

    @DataProvider(name = "testCreateFromFileNegativeFileProvider")
    public Object[][] createDataForFillMatrixFromFileNegativeFile() {
        return new Object[][]{
                {63, null},
                {15, null},
        };
    }

    @Test(description = "Negative scenario of creating matrix from file. Wrong size for create matrix",
            expectedExceptions = ServiceException.class, dataProvider = "testCreateFromFileNegativeSizeProvider",
            expectedExceptionsMessageRegExp = "Can't create matrix! Matrix size is 0 or negative value.")
    public void testCreateFromFileNegativeSize(int size, File file) throws ServiceException {
        creatorService.createFromFile(size, file);
    }

    @Test(description = "Negative scenario of creating matrix from file. File doesn't exist!",
            expectedExceptions = ServiceException.class, dataProvider = "testCreateFromFileNegativeFileProvider",
            expectedExceptionsMessageRegExp = "The file does not exist or the path is specified incorrectly!")
    public void testCreateFromFileNegativeFile(int size, File file) throws ServiceException {
        creatorService.createFromFile(size, file);
    }
}