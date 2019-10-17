package com.epam.programming_with_classes.simple_objects.customer;

public class Main {

    public static void main(String[] args) {

        Customer[] customers = new Customer[]{
                new Customer(11, "Bush", "John", "Malkovich", "city Washington", 339, 679011),
                new Customer(10, "Antonov", "Ivan", "Petrovich", "city Samara", 555, 439290),
                new Customer(12, "Kennedy", "Jack", "Maktavish", "city Boston", 450, 383567)};

        CustomerHelper base = new CustomerHelper(customers);
        base.printByCreditCardNumber(300, 400);
    }
}
