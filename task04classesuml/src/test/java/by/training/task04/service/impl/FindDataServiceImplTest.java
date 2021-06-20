package by.training.task04.service.impl;

import by.training.task04.bean.BankAccount;
import by.training.task04.bean.Client;
import by.training.task04.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Optional;

import static org.testng.Assert.*;

public class FindDataServiceImplTest {
    FindDataServiceImpl service = new FindDataServiceImpl();

    @DataProvider(name = "testFindByFIONegativePathProvider")
    public Object[][] createDataForFindByFIONegativePath() {
        return new Object[][]{
                {new Object[]{new File("./src/main/resources/datа/generatedData"), "wd"}, null},
                {new Object[]{new File("./src/main/res0urces/data/generatedDataTest.txt"), "dw"}, null},
                {new Object[]{new File("./src/resources/data/generatedData.tx"), "wd"}, null},
                {new Object[]{new File("./src/main/resources/datageneratedData.tx"), "wd"}, null},
        };
    }

    @DataProvider(name = "testFindByFIONullProvider")
    public Object[][] createDataForFindByFIONegativeFioNull() {
        return new Object[][]{
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), null}, null},
        };
    }

    @DataProvider(name = "testFindByFIONotFullProvider")
    public Object[][] createDataForFindByFIONegativeNotFullFIO() {
        return new Object[][]{
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), "Рожков Максим"}, null},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), "Стась"}, null},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), "Стась Юрий"}, null},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), "Савицкий"}, null},

        };
    }

    @DataProvider(name = "testFindByAccountNumberNegativePathProvider")
    public Object[][] createDataForFindByNumberNegativePath() {
        return new Object[][]{
                {new Object[]{new File("./src/main/resources/datа/generatedData"), 2000000000000000l}, null},
                {new Object[]{new File("./src/main/res0urces/data/generatedDataTest.txt"), 2000000000000000l}, null},
                {new Object[]{new File("./src/resources/data/generatedData.tx"), 2000000000000000l}, null},
                {new Object[]{new File("./src/main/resources/datageneratedData.tx"), 2000000000000000l}, null},
        };
    }

    @DataProvider(name = "testFindByAccountNumberNegativeNumberProvider")
    public Object[][] createDataForFindByNumberNegativeNumber() {
        return new Object[][]{
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), 1l}, null},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), 10000000000000000l}, null},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), 55555554844554521l}, null},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), 515185445441154l}, null},
        };
    }

    @DataProvider(name = "testFindByAccountNumberPositiveProvider")
    public Object[][] createDataForFindByNumberPositive() {
        return new Object[][]{
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), 5599358939943257l},
                        new BankAccount(5599358939943257l, 234792.36, "Заблокирован",
                                new Client(3, "Пупкин", "Юрий", "Иванович"))},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), 1520110112123876l},
                        new BankAccount(1520110112123876l, -412639.44, "Активен",
                                new Client(1, "Рожков", "Максим", "Артёмович"))},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), 2550791283717950l},
                        new BankAccount(2550791283717950l, 810226.17, "Активен",
                                new Client(10, "Савицкий", "Олег", "Егорович"))},
                {new Object[]{new File("./src/main/resources/data/dataTestCalcAmount.txt"), 4463805386843823l},
                        new BankAccount(4463805386843823l, 15582.24, "Активен",
                                new Client(5, "Стась", "Генадий", "Юрьевич"))},
        };
    }

    @Test(description = "Negative scenario of finding client!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for read data!",
            dataProvider = "testFindByFIONegativePathProvider")
    public void testFindByFIONegativePath(Object[] obj, Client result) throws ServiceException {
        File file = (File) obj[0];
        String fio = (String) obj[1];
        Optional<Client> actual = service.findByFIO(file, fio);
        assertEquals(actual.get(), result);
    }

    @Test(description = "Negative scenario of finding client (null fio)!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Can't find user without his FIO",
            dataProvider = "testFindByFIONullProvider")
    public void testFindByFIONull(Object[] obj, Client result) throws ServiceException {
        File file = (File) obj[0];
        String fio = (String) obj[1];
        Optional<Client> actual = service.findByFIO(file, fio);
        assertEquals(actual.get(), result);
    }

    @Test(description = "Negative scenario of finding client (not full fio)!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Not enough data to find a client",
            dataProvider = "testFindByFIONotFullProvider")
    public void testFindByFIONotFull(Object[] obj, Client result) throws ServiceException {
        File file = (File) obj[0];
        String fio = (String) obj[1];
        Optional<Client> actual = service.findByFIO(file, fio);
        assertEquals(actual.get(), result);
    }

    @Test(description = "Negative scenario of finding bank accounts!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Invalid file path for read data!",
            dataProvider = "testFindByAccountNumberNegativePathProvider")
    public void testFindByAccountNumberNegativePath(Object[] obj, BankAccount result) throws ServiceException {
        File file = (File) obj[0];
        long number = (long) obj[1];
        Optional<BankAccount> actual = service.findByAccountNumber(file, number);
        assertEquals(actual.get(), result);
    }

    @Test(description = "Negative scenario of finding bank accounts!",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Wrong value of account number!",
            dataProvider = "testFindByAccountNumberNegativeNumberProvider")
    public void testFindByAccountNumberNegativeNumber(Object[] obj, BankAccount result) throws ServiceException {
        File file = (File) obj[0];
        long number = (long) obj[1];
        Optional<BankAccount> actual = service.findByAccountNumber(file, number);
        assertEquals(actual.get(), result);
    }

    @Test(description = "Positive scenario of finding bank accounts!",
            dataProvider = "testFindByAccountNumberPositiveProvider")
    public void testFindByAccountNumberPositive(Object[] obj, BankAccount result) throws ServiceException {
        File file = (File) obj[0];
        long number = (long) obj[1];
        Optional<BankAccount> actual = service.findByAccountNumber(file, number);
        assertEquals(actual.get(), result);
    }
}