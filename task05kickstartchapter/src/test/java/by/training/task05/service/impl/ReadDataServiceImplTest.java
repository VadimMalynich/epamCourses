package by.training.task05.service.impl;

import by.training.task05.service.ServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ReadDataServiceImplTest {
    private ReadDataServiceImpl service = new ReadDataServiceImpl();
    private List<String> fileData1, fileData2, fileData3;
    private static final String FIRST_PATH = "data/tests/correct.txt";
    private static final String SECOND_PATH = "data/tests/correctAndIncorrect.txt";
    private static final String THIRD_PATH = "data/tests/incorrect.txt";

    @BeforeTest
    public void initialization() {
        fileData1 = new ArrayList<>();
        fileData1.add("triangle1 5 3.5 5 0 0 0");
        fileData1.add("triangle69 -2.6 -1 1.3 -1.75 -1 2.05");
        fileData1.add("triangle24 -3.4 -0.8 -4.6 -1.6 -4 -2.3");
        fileData1.add("tr2 -6.9 4.02 -5.74 5 -6.12 4.49");
        fileData1.add("triaNG 3.6 -2.99 4.86 -1.15 6.12 -3.30");

        fileData2 = new ArrayList<>();
        fileData2.add("triangle1 5 3.5 5 0 0 0");
        fileData2.add("triangle69 -s -1 1.3 -1.75 -1 2.05");
        fileData2.add("triangle24 -3.w -0.8 ffs -1.6 -4 -2.3");
        fileData2.add("tr2 -6.9 4.02 -5.74 5 -6.12 4.49");
        fileData2.add("triaNG 3.6 -2.99 4.86 -1.15 6.12 -3.30 -55.2");

        fileData3 = new ArrayList<>();
        fileData3.add("triangle1 5 3.5 5 0 0 0 5 3");
        fileData3.add("triangle69 -2.6 -1 1.3");
        fileData3.add("triangle24");
        fileData3.add("tr2 -6.9 4.w -5.74 dw -6.12 4.49");
        fileData3.add("triaNG 3.6 -wsd 4.86 -1.15 6.12 -3.30");
        fileData3.add("-3.4 -0.8 -4.6 -1.6 -4 -2.3");

    }

    @DataProvider(name = "testReadDataProvider")
    public Object[][] createDataForReadData() {
        return new Object[][]{
                {new File(FIRST_PATH), fileData1},
                {new File(SECOND_PATH), fileData2},
                {new File(THIRD_PATH), fileData3},
        };
    }

    @DataProvider(name = "testReadDataNegativeProvider")
    public Object[][] createDataForReadDataNegative() {
        return new Object[][]{
                {new File("correct.txt"), fileData1},
                {new File("data/tests"), fileData2},
                {new File("data/tests/corect.txt"), fileData3},
                {new File("data/tests/incorrect.txts"), fileData2},
                {new File("data/tests/correct.xml"), fileData3},
        };
    }

    @Test(description = "Positive scenario of read data from file", dataProvider = "testReadDataProvider")
    public void testReadData(File file, List<String> result) throws ServiceException {
        List<String> actual = service.readData(file);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of read data (wrong path)", dataProvider = "testReadDataNegativeProvider",
            expectedExceptions = ServiceException.class, expectedExceptionsMessageRegExp = "File doesn't exist!")
    public void testReadDataNegative(File file, List<String> result) throws ServiceException {
        List<String> actual = service.readData(file);
        assertEquals(actual, result);
    }
}