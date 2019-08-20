package com.epam.programming_with_classes.agregation_and_composition.customer;

import java.util.Arrays;

/*
. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(true, 123, "BankOfAmerica", 12);
        BankAccount bankAccount2 = new BankAccount(true, -34123, "BankOfAmerica", 4);

        Customer customer = new Customer("Jane", "Borph", new BankAccount[]{bankAccount1, bankAccount2});

        customer.blockBankAccount(12);

        System.out.println(Arrays.toString(customer.getBankAccounts()));

        System.out.println(customer.findBankAccount(12));

        customer.printAccountsSummary();

        customer.printNegativeAccountsSummary();

    }
}
