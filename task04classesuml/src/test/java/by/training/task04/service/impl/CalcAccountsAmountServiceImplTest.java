package by.training.task04.service.impl;

import by.training.task04.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class CalcAccountsAmountServiceImplTest {
    private CalcAccountsAmountServiceImpl service = new CalcAccountsAmountServiceImpl();

    @DataProvider(name = "testCalcAllAccountsAmountProvider")
    public Object[][] createDataForCalcAllAmounts() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestCalcAmount.txt"), 2449997.53},
        };
    }

    @DataProvider(name = "testCalcNegativeAccountsAmountProvider")
    public Object[][] createDataForCalcNegativeAmounts() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestCalcAmount.txt"), -1339387.85},
        };
    }

    @DataProvider(name = "testCalcPositiveAccountsAmountProvider")
    public Object[][] createDataForCalcPositiveAmounts() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestCalcAmount.txt"), 3789385.38},
        };
    }

    @DataProvider(name = "testReadDataNegativePathProvider")
    public Object[][] createDataForReadNegativePath() {
        return new Object[][]{
                {new File("./src/main/resources/datа/generatedData"), 2},
                {new File("./src/main/res0urces/data/generatedDataTest.txt"), 0},
                {new File("./src/resources/data/generatedData.tx"), 3},
                {new File("./src/main/resources/datageneratedData.tx"), 1},
        };
    }

    @Test(description = "Positive scenario of calculating all accounts amount",
            dataProvider = "testCalcAllAccountsAmountProvider")
    public void testCalcAllAccountsAmount(File file, double result) throws ServiceException {
        double actual = service.calcAllAccountsAmount(file);
        assertEquals(actual, result,0.01);
    }

    @Test(description = "Negative scenario of calculating all accounts amount!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for read data!",
            dataProvider = "testReadDataNegativePathProvider")
    public void testCalcAllAccountsAmountNegativePath(File file, double result) throws ServiceException {
        double actual = service.calcAllAccountsAmount(file);
        assertEquals(actual, result);
    }


    @Test(description = "Positive scenario of calculating negative accounts amount",
            dataProvider = "testCalcNegativeAccountsAmountProvider")
    public void testCalcNegativeAccountsAmount(File file, double result) throws ServiceException {
        double actual = service.calcNegativeAccountsAmount(file);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of calculating negative accounts amount!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for read data!",
            dataProvider = "testReadDataNegativePathProvider")
    public void testCalcNegativeAccountsAmountNegativePath(File file, double result) throws ServiceException {
        double actual = service.calcNegativeAccountsAmount(file);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of calculating positive accounts amount",
            dataProvider = "testCalcPositiveAccountsAmountProvider")
    public void testCalcPositiveAccountsAmount(File file, double result) throws ServiceException {
        double actual = service.calcPositiveAccountsAmount(file);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of calculating positive accounts amount!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for read data!",
            dataProvider = "testReadDataNegativePathProvider")
    public void testCalcPositiveAccountsAmountNegativePath(File file, double result) throws ServiceException {
        double actual = service.calcPositiveAccountsAmount(file);
        assertEquals(actual, result);
    }
}