package by.training.task04.service.impl;

import by.training.task04.bean.AccountStatus;
import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.bean.Client;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.DAOFactory;
import by.training.task04.dao.WriteToFile;
import by.training.task04.service.GenerateDataService;
import by.training.task04.service.ServiceException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateDataServiceImpl implements GenerateDataService {
    private static final String[] surnames = new String[]{"Кузин", "Пупкин", "Белов", "Стась", "Савицкий", "Медведев",
            "Попов", "Смирнов", "Абрамов", "Рожков"};
    private static final String[] names = new String[]{"Генадий", "Алексей", "Максим", "Ричард", "Никита", "Тимур",
            "Юрий", "Пётр", "Макар", "Олег"};
    private static final String[] patronymics = new String[]{"Алексеевич", "Борисович", "Егорович", "Ильич", "Юрьевич",
            "Михайлович", "Иванович", "Артёмович", "Глебович", "Викторович"};
    private static final String[] bankNames = new String[]{"Беларусбанк", "Альфа-Банк", "МТБанк", "БПС-Сбербанк",
            "Приорбанк", "Белинвестбанк", "Белгазпромбанк", "СтатусБанк", "ТехноБанк", "РРБ-Банк"};

    @Override
    public void generateDate(File file) throws ServiceException {
        String path = file.getPath();
        if (!path.startsWith(".\\src\\main\\resources\\data\\")) {
            throw new ServiceException("Invalid file path for generate data!");
        }
        List<BankAccount> bankAccounts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Client client = new Client(i + 1, surnames[getArrayValue()], names[getArrayValue()],
                    patronymics[getArrayValue()]);
            long number = generateAccountNumber();
            double amount = generateAmount();
            String status = generateStatus();
            BankAccount account = new BankAccount(number, amount, status, client);
            bankAccounts.add(account);
        }
        Bank bank = new Bank(bankNames[getArrayValue()], bankAccounts);
        DAOFactory daoFactory = DAOFactory.getInstance();
        WriteToFile write = daoFactory.getWriteToFile();

        try {
            write.writeGenerateData(file, bank);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Method for generate random index from 0 to 9 for taking value from array
     *
     * @return value from 0 to 9
     */
    private int getArrayValue() {
        return (int) (0 + Math.random() * 10);
    }

//    private int generateID() {
//        int id = (int) (1000 + Math.random() * 9000);
//        return id;
//    }

    /**
     * Method for generate random account number
     *
     * @return 16-digit number
     */
    private long generateAccountNumber() {
        return (long) (1000000000000000l + Math.random() * 9000000000000000l);
    }

    /**
     * Method generate random account amount from -1000000 to 1000000
     *
     * @return account amount
     */
    private double generateAmount() {
        return (-1000000 + Math.random() * 2000000);
    }

    /**
     * The method generates a value and, in accordance with the value, assigns a status to the account
     *
     * @return account status
     */
    private String generateStatus() {
        int value = (int) (0 + Math.random() * 2);
        String status;
        status = value == 0 ? AccountStatus.BLOCKED.getValue() : AccountStatus.ACTIVE.getValue();
        return status;
    }
}
