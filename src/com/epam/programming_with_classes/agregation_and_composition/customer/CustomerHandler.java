package com.epam.programming_with_classes.agregation_and_composition.customer;

import java.util.Arrays;
import java.util.stream.Stream;

public class CustomerHandler {
    public void blockBankAccount(Customer customer, int id) {

        Stream.of(customer.getBankAccounts())
                .filter(bankAccount -> bankAccount.getId() == id)
                .findFirst()
                .get()
                .setActive(true);
    }

    public BankAccount findBankAccount(Customer customer, int id) {

        return Stream.of(customer.getBankAccounts())
                .filter(bankAccount -> bankAccount.getId() == id)
                .findFirst().orElse(null);
    }

    public void sortBankAccounts(Customer customer) {

        Arrays.sort(customer.getBankAccounts(), (bankAccount1, bankAccount2) ->
                bankAccount1.getBalance() >= bankAccount2.getBalance() ? 1 : -1);
    }

    public void printAccountsSummary(Customer customer) {

        double summary = Stream.of(customer.getBankAccounts()).mapToDouble(BankAccount::getBalance).sum();

        System.out.println(summary);
    }

    public void printPositiveAccountsSummary(Customer customer) {

        double summary = Stream.of(customer.getBankAccounts())
                .filter(bankAccount -> bankAccount.getBalance() >= 0)
                .mapToDouble(BankAccount::getBalance).sum();

        System.out.println(summary);
    }

    public void printNegativeAccountsSummary(Customer customer) {

        double summary = Stream.of(customer.getBankAccounts())
                .filter(bankAccount -> bankAccount.getBalance() <= 0)
                .mapToDouble(BankAccount::getBalance).sum();

        System.out.println(summary);
    }


}
