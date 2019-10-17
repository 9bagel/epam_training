package com.epam.basic_of_oop.dragon_cave.treasure;

import java.util.Random;

public class Treasure {
    private TreasureName name;
    private TreasureType type;
    private int price;

    public Treasure() {
        this.name = TreasureName.getRandomName();
        this.type = TreasureType.getRandomType();
        this.price = new Random().nextInt(100);
    }

    public Treasure(TreasureName name, TreasureType type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public TreasureName getName() {
        return name;
    }

    public void setName(TreasureName name) {
        this.name = name;
    }

    public TreasureType getType() {
        return type;
    }

    public void setType(TreasureType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "name=" + name +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
