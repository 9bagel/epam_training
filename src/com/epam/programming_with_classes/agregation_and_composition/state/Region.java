package com.epam.programming_with_classes.agregation_and_composition.state;

import java.util.ArrayList;

/*
Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры.
 */
class Region {
    private String regionName;
    private ArrayList<District> districts = new ArrayList<>();

    public Region(String regionName, ArrayList<District> districts) {
        this.regionName = regionName;
        this.districts = districts;
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }

    public void setDistricts(District district){
        districts.add(district);
    }
}
