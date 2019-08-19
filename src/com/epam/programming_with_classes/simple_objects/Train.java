package com.epam.programming_with_classes.simple_objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/*
Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
назначения должны быть упорядочены по времени отправления.
 */

public class Train {
    private String destinationName;
    private int trainNumber;
    private Date departureTime;

    private Train(String destinationName, int trainNumber, String departureTime) {
        this.destinationName = destinationName;
        this.trainNumber = trainNumber;

        try {
            this.departureTime = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").parse(departureTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Train() {
    }

    public static void main(String[] args) {
        Train train = new Train();
        Train[] trains = train.createTrains();

        train.sortByDestinationName(trains);
    }

    private void sortByTrainNumber(Train[] trains) {
        Arrays.sort(trains, Comparator.comparingInt(Train::getTrainNumber));

        print(trains);
    }

    /*Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
    назначения должны быть упорядочены по времени отправления.
     */
    private void sortByDestinationName(Train[] trains) {
        Arrays.sort(trains, Comparator.comparing(Train::getDestinationName).thenComparing(Train::getDepartureTime));

        print(trains);
    }

    //Возможность вывода информации о поезде, номер которого введен пользователем.
    void getInfoByTrainNumber(Train[] trains) {
        int trainNumber = enterTrainNumber();

        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                print(train);
            } else System.out.println("Поезда с таким номером нет");
        }
    }

    private int enterTrainNumber() {

        int trainNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер поезда");

        while (!scanner.hasNextInt()) {
            System.out.println("Это должно быть число");
            scanner.next();
        }

        trainNumber = scanner.nextInt();

        return trainNumber;
    }

    void print(Train[] trains) {
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    void print(Train train) {
        System.out.printf("Пункт назначения: %s \nНомер поезда: %d\nВремя отправления: %s", train.getDestinationName(), train.getTrainNumber(), train.getDepartureTime().toString());
    }

    private String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    private int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    private Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    private Train[] createTrains() {

        Train[] trains = new Train[]{
                new Train("Минск", 133, "13:30:00 12/08/2019"),
                new Train("Гомель", 15, "14:00:00 12/07/2019"),
                new Train("Бобруйск", 23, "14:30:00 12/10/2019"),
                new Train("Витебск", 5, "15:00:00 12/09/2019"),
                new Train("Витебск", 11, "15:30:00 21/08/2019")};

        return trains;
    }

    @Override
    public String toString() {
        return "Пункт назначения: " + this.getDestinationName() + " номер поезда: " + this.getTrainNumber() + " время отправления: " + this.getDepartureTime().toString();
    }
}
