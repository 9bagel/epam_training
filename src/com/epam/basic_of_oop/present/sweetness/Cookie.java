package com.epam.basic_of_oop.present.sweetness;

public class Cookie implements Sweetness {
    private String name;
    private int price;

    public Cookie(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
