package com.epam.programming_with_classes.simple_objects.train;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TrainHandler {

    public void sortByTrainNumber(Train[] trains) {
        Arrays.sort(trains, Comparator.comparingInt(Train::getTrainNumber));

        print(trains);
    }

    /*Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
    назначения должны быть упорядочены по времени отправления.
     */
    public void sortByDestinationName(Train[] trains) {
        Arrays.sort(trains, Comparator.comparing(Train::getDestinationName).thenComparing(Train::getDepartureTime));

        print(trains);
    }

    //Возможность вывода информации о поезде, номер которого введен пользователем.
    public void getInfoByTrainNumber(Train[] trains) {
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

    public void print(Train[] trains) {
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    public void print(Train train) {
        System.out.printf("Пункт назначения: %s \nНомер поезда: %d\nВремя отправления: %s", train.getDestinationName(), train.getTrainNumber(), train.getDepartureTime().toString());
    }


    public Train[] createTrains() {

        Train[] trains = new Train[]{
                new Train("Минск", 133, "13:30:00 12/08/2019"),
                new Train("Гомель", 15, "14:00:00 12/07/2019"),
                new Train("Бобруйск", 23, "14:30:00 12/10/2019"),
                new Train("Витебск", 5, "15:00:00 12/09/2019"),
                new Train("Витебск", 11, "15:30:00 21/08/2019")};

        return trains;
    }

}
