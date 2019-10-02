package com.epam.basic_of_oop.present;

import com.epam.basic_of_oop.present.sweetness.SweetnessFactory;
import com.epam.basic_of_oop.present.sweetness.SweetnessType;
import com.epam.basic_of_oop.present.wrap.WrapFactory;
import com.epam.basic_of_oop.present.wrap.WrapType;

public class Main {
    public static void main(String[] args) {

        Present present = new Present();
        SweetnessFactory sweetnessFactory = new SweetnessFactory();

        present.addSweetness(sweetnessFactory.createSweetness(SweetnessType.CAKE, "Vanilla cake", 43));
        present.addSweetness(sweetnessFactory.createSweetness(SweetnessType.CANDY, "Chocolate candy", 15));
        present.addSweetness(sweetnessFactory.createSweetness(SweetnessType.COOKIE, "ahhh cookie", 23));
        present.addSweetness(sweetnessFactory.createSweetness(SweetnessType.DONUT, "Homer's one", 8));

        WrapFactory wrapFactory = new WrapFactory();

        present.setWrap(wrapFactory.createWrap(WrapType.BASKET, "With love...", "Love"));

        System.out.println(present);
    }
}
