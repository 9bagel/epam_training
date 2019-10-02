package com.epam.basic_of_oop.present;

import com.epam.basic_of_oop.present.sweetness.Sweetness;
import com.epam.basic_of_oop.present.wrap.Wrap;

import java.util.ArrayList;

public class Present {
    private ArrayList<Sweetness> sweetnesses = new ArrayList<>();
    private Wrap wrap;

    void addSweetness(Sweetness sweetness) {
        sweetnesses.add(sweetness);
    }

    public Wrap getWrap() {
        return wrap;
    }

    public void setWrap(Wrap wrap) {
        this.wrap = wrap;
    }

    @Override
    public String toString() {
        return "Present{" +
                "sweetnesses=" + sweetnesses +
                ", wrap=" + wrap +
                '}';
    }
}
