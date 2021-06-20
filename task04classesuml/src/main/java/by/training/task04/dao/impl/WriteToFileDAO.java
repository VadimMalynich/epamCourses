package by.training.task04.dao.impl;

import by.training.task04.bean.Bank;
import by.training.task04.bean.BankAccount;
import by.training.task04.dao.DAOException;
import by.training.task04.dao.WriteToFile;

import java.io.*;

public class WriteToFileDAO implements WriteToFile {

    @Override
    public void writeGenerateData(File file, Bank bank) throws DAOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            StringBuilder builder = new StringBuilder();
            builder.append("Банк: " + bank.getTitle() + "\n");
            builder.append(String.format("%6s", "ID") + String.format("%15s", "Surname") + String.format("%10s", "Name") +
                    String.format("%15s", "Patronymic") + String.format("%18s", "Account number") +
                    String.format("%16s", "Account amount") + String.format("%16s", "Account status") + "\n");
            for (BankAccount account : bank.getBankAccounts()) {
                buildLines(builder, account);
            }
            bw.write(String.valueOf(builder));
        } catch (IOException e) {
            throw new DAOException(e);
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    private void buildLines(StringBuilder builder, BankAccount account) {
        builder.append(String.format("%6d", account.getClient().getId()));
        builder.append(String.format("%15s", account.getClient().getSurname()));
        builder.append(String.format("%10s", account.getClient().getName()));
        builder.append(String.format("%15s", account.getClient().getPatronymic()));
        builder.append(String.format("%18d", account.getAccountNumber()));
        builder.append(String.format("%16.2f", account.getAccountAmount()).replace(',', '.'));
        builder.append(String.format("%16s", account.getAccountStatus()));
        builder.append("\n");
    }
}
