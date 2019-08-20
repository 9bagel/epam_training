package com.epam.programming_with_classes.agregation_and_composition.state;

import java.util.ArrayList;

/*
Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры.
 */
class District {
    private String districtName;
    private ArrayList<City> cities = new ArrayList<>();

    public District(String districtName, ArrayList<City> cities) {
        this.districtName = districtName;
        this.cities = cities;
    }

    public District(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    void setCities(City city) {
        cities.add(city);
    }
}
