package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.bean.Client;
import by.training.task04.service.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Optional;

import static org.testng.Assert.*;

public class ReadFromFileServiceImplTest {
    private ReadFromFileServiceImpl read = new ReadFromFileServiceImpl();

    @DataProvider(name = "testReadDataPositiveProvider")
    public Object[][] createDataForReadPositivePath() {
        return new Object[][]{
                {new File("./src/main/resources/data/dataTestStatus.txt"), new Bank("Белинвестбанк")},
        };
    }

    @DataProvider(name = "testReadDataNegativeProvider")
    public Object[][] createDataForReadNegativePath() {
        return new Object[][]{
                {new File("./src/main/resources/datа/generatedData"), new Bank()},
                {new File("./src/main/res0urces/data/generatedDataTest.txt"), new Bank()},
                {new File("./src/resources/data/generatedData.tx"), new Bank()},
                {new File("./src/main/resources/datageneratedData.tx"), new Bank()},
        };
    }

    @Test(description = "Positive scenario of reading data from file!",
            dataProvider = "testReadDataPositiveProvider")
    public void testReadDataPositive(File file, Bank result) throws ServiceException {
        Client client = new Client(1, "Смирнов", "Алексей", "Ильич");
        BankAccount account = new BankAccount(4701750283805023l, 407528.68, "Активен", client);
        result.addBankAccount(account);
        client = new Client(2, "Белов", "Генадий", "Борисович");
        account = new BankAccount(8109959352690769L, -684573.18, "Активен", client);
        result.addBankAccount(account);
        client = new Client(3, "Попов", "Тимур", "Михайлович");
        account = new BankAccount(3161129377154405L, 368990.19, "Заблокирован", client);
        result.addBankAccount(account);
        Optional<Bank> actual = read.readData(file);
        assertEquals(actual.get(), result);
    }

    @Test(description = "Negative scenario of reading data from file!",
            expectedExceptions = ServiceException.class,
            dataProvider = "testReadDataNegativeProvider")
    public void testReadDataNegative(File file, Bank result) throws ServiceException {
        Optional<Bank> actual = read.readData(file);
        assertEquals(actual.get(), result);
    }
}