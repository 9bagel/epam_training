package com.epam.programming_with_classes.agregation_and_composition.vehicle;

/*
Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля.
 */
public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(
                new Wheel(18, "Yokohama"),
                new Engine(3.2, EngineType.GASOLINE, 60), "Toyota");
    }
}
