package com.epam.basic_of_oop.payment;

/*
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров.
 */
public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();

        Payment.Product product = payment.new Product("Eggs", 4, 0.4);

        payment.purchase(product, 10);

        System.out.println(payment.getTotalAmount());
    }
}
