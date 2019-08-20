package com.epam.programming_with_classes.agregation_and_composition.customer;

import java.util.Arrays;
import java.util.stream.Stream;

/*
. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
всем счетам, имеющим положительный и отрицательный балансы отдельно.

 */
public class Customer {
    private String firstName;
    private String lastName;

    private BankAccount[] bankAccounts;

    public Customer(String firstName, String lastName, BankAccount[] bankAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccounts = bankAccounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(BankAccount[] bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    void blockBankAccount(int id) {

        Stream.of(bankAccounts)
                .filter(bankAccount -> bankAccount.getId() == id)
                .findFirst()
                .get()
                .setActive(false);
    }

    BankAccount findBankAccount(int id) {

        return Stream.of(bankAccounts)
                .filter(bankAccount -> bankAccount.getId() == id)
                .findFirst().get();
    }

    void sortBankAccounts() {

        Arrays.sort(bankAccounts, (bankAccount1, bankAccount2) ->
                bankAccount1.getBalance() >= bankAccount2.getBalance() ? 1 : -1);
    }

    void printAccountsSummary() {

        double summary = Stream.of(bankAccounts).mapToDouble(BankAccount::getBalance).sum();

        System.out.println(summary);
    }

    void printPositiveAccountsSummary() {

        double summary = Stream.of(bankAccounts)
                .filter(bankAccount -> bankAccount.getBalance() >= 0)
                .mapToDouble(BankAccount::getBalance).sum();

        System.out.println(summary);
    }

    void printNegativeAccountsSummary() {

        double summary = Stream.of(bankAccounts)
                .filter(bankAccount -> bankAccount.getBalance() <= 0)
                .mapToDouble(BankAccount::getBalance).sum();

        System.out.println(summary);
    }


}
