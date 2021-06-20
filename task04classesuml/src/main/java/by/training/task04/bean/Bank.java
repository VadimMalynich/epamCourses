package by.training.task04.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private String title;
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public Bank() {
    }

    public Bank(String title) {
        this.title = title;
    }

    public Bank(String title, List<BankAccount> bankAccounts) {
        this.title = title;
        this.bankAccounts = bankAccounts;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addBankAccount(BankAccount account) {
        bankAccounts.add(account);
    }

    public void deleteBankAccount(BankAccount account) {
        bankAccounts.remove(account);
    }


    public String getTitle() {
        return title;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(title, bank.title) && Objects.equals(bankAccounts, bank.bankAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, bankAccounts);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Bank{ title='" + title + '\'' + ", bankAccounts=\n");
        for (BankAccount accounts : bankAccounts) {
            builder.append(accounts.toString());
            builder.append('\n');
        }
        return builder.toString();
    }

}

