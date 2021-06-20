package by.training.task04.bean;

import java.util.List;
import java.util.Objects;

public class Client {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private List<BankAccount> bankAccounts;

    public Client(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Client(int id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void addBankAccount(BankAccount account) {
        bankAccounts.add(account);
    }

    public void deleteBankAccount(int index) {
        bankAccounts.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(surname, client.surname) && Objects.equals(name, client.name) && Objects.equals(patronymic, client.patronymic) && Objects.equals(bankAccounts, client.bankAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, bankAccounts);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}
