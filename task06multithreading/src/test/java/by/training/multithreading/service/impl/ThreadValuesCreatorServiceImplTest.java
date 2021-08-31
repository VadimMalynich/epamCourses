package by.training.multithreading.service.impl;

import by.training.multithreading.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class ThreadValuesCreatorServiceImplTest {
    ThreadValuesCreatorServiceImpl creatorService = new ThreadValuesCreatorServiceImpl();

    @DataProvider(name = "testCreateFromFileNegativeSizeProvider")
    public Object[][] createDataForFillThreadValuesArrayFromFileNegativeSize() {
        return new Object[][]{
                {-22, new File("")},
                {0, new File("")},
                {-1000, new File("data/test.txt")}
        };
    }

    @DataProvider(name = "testCreateFromFileNegativeFileProvider")
    public Object[][] createDataForFillThreadValuesArrayFromFileNegativeFile() {
        return new Object[][]{
                {2000, null},
                {59, null},
                {1, null},
        };
    }


    @Test(description = "Negative scenario of creating thread values. Wrong size for thread values array",
            expectedExceptions = ServiceException.class, dataProvider = "testCreateFromFileNegativeSizeProvider",
            expectedExceptionsMessageRegExp = "Can't create array of thread values! Array size is 0 or negative value.")
    public void testCreateFromFileNegativeSize(int size, File file) throws ServiceException {
        creatorService.createFromFile(size, file);
    }

    @Test(description = "Negative scenario of creating thread values. File doesn't exist.",
            expectedExceptions = ServiceException.class, dataProvider = "testCreateFromFileNegativeFileProvider",
            expectedExceptionsMessageRegExp = "The file does not exist or the path is specified incorrectly!")
    public void testCreateFromFileNegativeFile(int size, File file) throws ServiceException {
        creatorService.createFromFile(size, file);
    }
}