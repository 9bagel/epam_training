package com.epam.programming_with_classes.agregation_and_composition.vehicle;

/*
Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля.
 */
public class Engine {
    private double engineCapacity;
    private EngineType engineType;
    private int tankCapacity;

    public Engine(double engineCapacity, EngineType engineType, int tankCapacity) {
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
        this.tankCapacity = tankCapacity;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}


