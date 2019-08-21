package com.epam.basic_of_oop.payment;

import java.util.HashMap;
import java.util.Map;

/*
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров.
 */
public class Payment {

    private Map<Product, Integer> productsList = new HashMap<>();

    //Покупка определённого товара
    void purchase(Product product, int amount) {
        productsList.put(product, amount);
    }

    public Map<Product, Integer> getProductsList() {
        return productsList;
    }

    public void setProductsList(Map<Product, Integer> productsList) {
        this.productsList = productsList;
    }

    //Покупка нескольких продуктов
    void purchase(Map<Product, Integer> productsList) {
        this.productsList.putAll(productsList);
    }
    //Определяем общую стоимость
    double getTotalAmount() {
        return productsList.entrySet().stream()
                .mapToDouble(productsList -> productsList.getKey().getPrice() * productsList.getValue()).sum();
    }

    class Product {
        private String name;
        private double price;
        private double weight;

        public Product(String name, double price, double weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }

}
