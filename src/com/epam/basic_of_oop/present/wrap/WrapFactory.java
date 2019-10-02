package com.epam.basic_of_oop.present.wrap;

public class WrapFactory {
    public Wrap createWrap(WrapType wrapType, String msg, String material) {
        switch (wrapType) {
            case BOX:
                return new Box(msg, material);
            case BASKET:
                return new Basket(msg, material);
            default:
                System.out.println("Что-то пошло не так");
                return null;
        }
    }
}
