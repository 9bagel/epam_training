package com.epam.programming_with_classes.agregation_and_composition.state;

import java.util.Arrays;

/*
Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры.
 */
public class State {
    private Region[] regions;
    private String stateName;
    private String capital;
    private double square;
    private District[] districts;

    public State(Region[] regions, String stateName, String capital, double square, District[] districts) {
        this.regions = regions;
        this.stateName = stateName;
        this.capital = capital;
        this.square = square;
        this.districts = districts;
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    void printCapital() {
        System.out.println(capital);
    }

    void printNumOfRegions() {
        System.out.println(regions.length);
    }

    void printSquare() {
        System.out.println(square);
    }

    void printDistrictsNames() {
        System.out.println(Arrays.toString(districts));
    }
}
