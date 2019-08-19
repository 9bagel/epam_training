package com.epam.programming_with_classes.simple_objects.customer;

/*
Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 */
public class Customer {
    int id;
    String lastName;
    String name;
    String middleName;
    String address;
    int creditNumber;
    int bankNumber;

    public static void main(String[] args) {

        Customer[] customers = new Customer[]{
                new Customer(11, "Bush", "John", "Malkovich", "city Washington", 339, 679011),
                new Customer(10, "Antonov", "Ivan", "Petrovich", "city Samara", 555, 439290),
                new Customer(12, "Kennedy", "Jack", "Maktavish", "city Boston", 450, 383567)};
        CustomerHelper base = new CustomerHelper(customers);
        base.printByCreditCardNumber(300, 400);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", creditNumber=" + creditNumber +
                ", bankNumber=" + bankNumber +
                '}';
    }

    public Customer(int id, String lastName, String name, String middleName, String address, int creditNumber, int bankNumber) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.creditNumber = creditNumber;
        this.bankNumber = bankNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }
}
