package com.epam.basic_of_oop.dragon_cave;

import com.epam.basic_of_oop.dragon_cave.treasure.Treasure;

import java.util.ArrayList;
import java.util.Comparator;

class Cave {
    private int treasureCount;

    private ArrayList<Treasure> treasures = new ArrayList<>();

    Cave(int treasureCount) {
        this.treasureCount = treasureCount;
    }

    public void createTreasures() {
        if (treasureCount < 0) {
            System.out.println("Нельзя создать отрицательное число сокровищ");
            return;
        }

        for (int i = 0; i < treasureCount; i++) {
            treasures.add(new Treasure());
        }
    }

    public void printMostExpensiveTreasure() {
        if (treasures != null) {
            System.out.println(treasures.stream().max(Comparator.comparingInt(Treasure::getPrice)).get());
        }
    }

    public void printAllTreasures() {
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
    }

    public void printOnSum(int sum) {
        int tmpSum = 0;

        for (Treasure treasure : treasures) {

            if ((tmpSum += treasure.getPrice()) >= sum) {
                tmpSum -= treasure.getPrice();
            } else System.out.println(treasure);
        }

        System.out.println("Общая сумма = " + tmpSum);
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }
}
