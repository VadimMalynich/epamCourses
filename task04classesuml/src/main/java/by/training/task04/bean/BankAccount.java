package by.training.task04.bean;

import java.util.Objects;

public class BankAccount {
    private long accountNumber;
    private double accountAmount;
    private String accountStatus;
    private Client client;

    public BankAccount(long accountNumber, double accountAmount, String accountStatus, Client client) {
        this.accountNumber = accountNumber;
        this.accountAmount = accountAmount;
        this.accountStatus = accountStatus;
        this.client = client;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getAccountAmount() {
        return accountAmount;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount account = (BankAccount) o;
        return accountNumber == account.accountNumber && Double.compare(account.accountAmount, accountAmount) == 0 && Objects.equals(accountStatus, account.accountStatus) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountAmount, accountStatus, client);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "client=" + client +
                ", accountNumber=" + accountNumber +
                ", accountAmount=" + accountAmount +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
