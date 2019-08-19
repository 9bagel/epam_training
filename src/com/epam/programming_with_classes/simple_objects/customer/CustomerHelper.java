package com.epam.programming_with_classes.simple_objects.customer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/*
Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
и методами.
Найти и вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */
public class CustomerHelper {
    private Customer[] customers;

    public CustomerHelper(Customer[] customers) {
        this.customers = customers;
    }

    //список покупателей в алфавитном порядке
    private void sortCustomersAlphabetic(Customer[] customers) {

        Arrays.sort(customers, Comparator.comparing(Customer::getLastName)
                .thenComparing(Customer::getName)
                .thenComparing(Customer::getMiddleName));
    }
    //список покупателей, у которых номер кредитной карточки находится в заданном интервале
    public void printByCreditCardNumber(int start, int end) {
        Stream.of(customers).filter(customer -> customer.getCreditNumber() >= start && customer.getCreditNumber() <= end).forEach(System.out::println);
    }
}
