package by.training.task04.dao.impl;

import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.bean.Client;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.ReadFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class ReadDataDAO implements ReadFromFile {

    @Override
    public Optional<Bank> readData(File file) throws DAOException {
        Bank bank = new Bank();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str = br.readLine();
            str = str.substring(6);
            bank.setTitle(str);
            str = br.readLine();
            while ((str = br.readLine()) != null) {
                str = str.trim();
                String[] data = str.split("\\s{1,}");
                Client client = new Client(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                long accountNumber = Long.parseLong(data[4]);
                double accountAmount = Double.parseDouble(data[5]);
                String status = data[6];
                BankAccount bankAccount = new BankAccount(accountNumber, accountAmount, status, client);
                bank.addBankAccount(bankAccount);
            }
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
        return Optional.of(bank);
    }
}
