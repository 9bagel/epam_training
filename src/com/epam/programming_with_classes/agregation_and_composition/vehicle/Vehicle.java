package com.epam.programming_with_classes.agregation_and_composition.vehicle;

/*
Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля.
 */
public class Vehicle {
    private Wheel wheel;
    private Engine engine;
    private int fuelLvl;
    private String carModel;

    Vehicle(Wheel wheel, Engine engine, String carModel) {
        this.wheel = wheel;
        this.engine = engine;
        this.carModel = carModel;
    }

    public int getFuelLvl() {
        return fuelLvl;
    }

    public void setFuelLvl(int fuelLvl) {
        this.fuelLvl = fuelLvl;
    }

    public Wheel getWheel() {
        return wheel;
    }

    //Меняем колесо
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    void drive() {

        if (fuelLvl != 0) {
            System.out.println("Поехали!");
            //Каждый час поездки будет отнимать объём двигателя * 3 литров топлива)
            while (fuelLvl > 0) {
                fuelLvl -= 3 * engine.getEngineCapacity();
                try {
                    Thread.sleep(1000);
                    System.out.println("Едем, едем...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } else {
            System.out.println("Нужно заправиться");
            fuelLvl = 0;
        }
    }

    void refuel(int fuelAmount) {

        if (fuelLvl + fuelAmount > this.engine.getTankCapacity()) {
            System.out.printf("Можно залить только %d литров топлива", this.engine.getTankCapacity() - fuelLvl);
        } else fuelLvl += fuelAmount;
    }

    void printCarModel() {
        System.out.println(carModel);
    }
}
