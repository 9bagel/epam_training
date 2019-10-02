package com.epam.basic_of_oop.dragon_cave.treasure;

import java.util.Random;

public enum TreasureName {
    KINGS_CROWN,
    GOLDEN_CUP,
    GOLDEN,
    SILVER_TABLEWARE,
    ROYAL_SCEPTER,
    BELT_DECORATED_WITH_GOLD,
    FUR_GOWN,
    LEAKY_SHIRT,
    TREASURE_CHEST;

    private static final TreasureName[] TREASURE_NAMES = values();
    private static final int SIZE = TreasureName.values().length;
    private static final Random RANDOM = new Random();

    public static TreasureName getRandomName() {
        return TREASURE_NAMES[RANDOM.nextInt(SIZE)];
    }
}