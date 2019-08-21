package com.epam.programming_with_classes.agregation_and_composition.travel;

/*
Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class Vacation {

    private VacationType vacationType;
    private String transportType;
    private String foodType;
    private int numberOfDays;
    private String country;

    public Vacation(VacationType vacationType, String transportType, String foodType, int numberOfDays, String country) {
        this.vacationType = vacationType;
        this.transportType = transportType;
        this.foodType = foodType;
        this.numberOfDays = numberOfDays;
        this.country = country;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "vacation=" + vacationType +
                ", transportType='" + transportType + '\'' +
                ", foodType='" + foodType + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", country='" + country + '\'' +
                '}';
    }
}
