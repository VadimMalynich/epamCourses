package by.training.task04.service.impl;

import by.training.task04.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class WorkWithStatusServiceImplTest {
    WorkWithStatusServiceImpl workWithStatusService = new WorkWithStatusServiceImpl();

    @DataProvider(name = "testBlockedAllAccountsPositiveProvider")
    public Object[][] blockedAllAccounts() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestStatus.txt"), 3},
        };
    }

    @DataProvider(name = "testBlockedAccountPositiveProvider")
    public Object[][] blockedAccount() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestStatus.txt"), 3},
                {new File("./src/main/resources/data/dataTestStatus.txt"), 2},
        };
    }

    @DataProvider(name = "testBlockedAccountNegativeIndexProvider")
    public Object[][] blockedAccountNegative() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestStatus.txt"), 0},
                {new File("./src/main/resources/data/dataTestStatus.txt"), -55},
                {new File("./src/main/resources/data/dataTestStatus.txt"), -5842},
                {new File("./src/main/resources/data/dataTestStatus.txt"), -1},
        };
    }

    @DataProvider(name = "testActivateAllAccountsPositiveProvider")
    public Object[][] activateAllAccounts() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestStatus.txt"), 3},
        };
    }

    @DataProvider(name = "testActivateAccountPositiveProvider")
    public Object[][] activateAccount() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestStatus.txt"), 3},
                {new File("./src/main/resources/data/dataTestStatus.txt"), 1},
        };
    }

    @DataProvider(name = "testActivateAccountNegativeIndexProvider")
    public Object[][] activateAccountNegative() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestStatus.txt"), 0},
                {new File("./src/main/resources/data/dataTestStatus.txt"), -55},
                {new File("./src/main/resources/data/dataTestStatus.txt"), -5842},
                {new File("./src/main/resources/data/dataTestStatus.txt"), -1},
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

    @Test(description = "Positive scenario of blocking all accounts!",
            dataProvider = "testBlockedAllAccountsPositiveProvider")
    public void testBlockedAllAccountsPositive(File file, int index) throws ServiceException {
        workWithStatusService.blockedAllAccounts(file);
    }

    @Test(description = "Negative scenario of blocking all accounts!",
            expectedExceptions = ServiceException.class,
            dataProvider = "testReadDataNegativePathProvider")
    public void testBlockedAllAccountsNegative(File file, int index) throws ServiceException {
        workWithStatusService.blockedAllAccounts(file);
    }

    @Test(description = "Positive scenario of blocking account!",
            dataProvider = "testBlockedAccountPositiveProvider")
    public void testBlockedAccountPositive(File file, int index) throws ServiceException {
        workWithStatusService.blockedAccount(file, index);
    }

    @Test(description = "Negative index scenario of blocking account!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Index for change status should be > 0!",
            dataProvider = "testBlockedAccountNegativeIndexProvider")
    public void testBlockedAccountNegativeIndex(File file, int index) throws ServiceException {
        workWithStatusService.blockedAccount(file, index);
    }

    @Test(description = "Negative path scenario of blocking account!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for read data!",
            dataProvider = "testReadDataNegativePathProvider")
    public void testBlockedAccountNegativePath(File file, int index) throws ServiceException {
        workWithStatusService.blockedAccount(file, index);
    }

    @Test(description = "Positive scenario of activating all accounts!",
            dataProvider = "testActivateAllAccountsPositiveProvider")
    public void testActivateAllAccountsPositive(File file, int index) throws ServiceException {
        workWithStatusService.activateAllAccounts(file);
    }

    @Test(description = "Negative scenario of activating all accounts!",
            expectedExceptions = ServiceException.class,
            dataProvider = "testReadDataNegativePathProvider")
    public void testActivateAllAccountsNegative(File file, int index) throws ServiceException {
        workWithStatusService.activateAllAccounts(file);
    }

    @Test(description = "Positive scenario of activating account!",
            dataProvider = "testActivateAccountPositiveProvider")
    public void testActivateAccountPositive(File file, int index) throws ServiceException {
        workWithStatusService.activateAccount(file, index);
    }

    @Test(description = "Negative index scenario of activating account!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Index for change status should be > 0!",
            dataProvider = "testActivateAccountNegativeIndexProvider")
    public void testActivateAccountNegativeIndex(File file, int index) throws ServiceException {
        workWithStatusService.activateAccount(file, index);
    }

    @Test(description = "Negative path scenario of activating account!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for read data!",
            dataProvider = "testReadDataNegativePathProvider")
    public void testActivateAccountNegativePath(File file, int index) throws ServiceException {
        workWithStatusService.activateAccount(file, index);
    }
}