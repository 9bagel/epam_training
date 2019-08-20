package com.epam.programming_with_classes.agregation_and_composition.customer;

import java.math.BigDecimal;

/*
. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
всем счетам, имеющим положительный и отрицательный балансы отдельно.

 */
public class BankAccount {
    private boolean isActive;
    private double balance;
    private String bankName;
    private int id;

    public BankAccount(boolean isActive, double balance, String bankName, int id) {
        this.isActive = isActive;
        this.balance = balance;
        this.bankName = bankName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "isActive=" + isActive +
                ", balance=" + balance +
                ", bankName='" + bankName + '\'' +
                ", id=" + id +
                '}';
    }
}
