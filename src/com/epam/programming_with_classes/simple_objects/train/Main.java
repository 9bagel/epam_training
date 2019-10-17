package com.epam.programming_with_classes.simple_objects.train;

/*
Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
назначения должны быть упорядочены по времени отправления.
 */

public class Main {
    public static void main(String[] args) {
        TrainHandler trainHandler = new TrainHandler();

        Train[] trains = trainHandler.createTrains();

        trainHandler.sortByDestinationName(trains);
    }
}
