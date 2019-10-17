package com.epam.programming_with_classes.simple_objects.train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Train(String destinationName, int trainNumber, String departureTime) {
        this.destinationName = destinationName;
        this.trainNumber = trainNumber;

        try {
            this.departureTime = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").parse(departureTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Пункт назначения: " + this.getDestinationName() + " номер поезда: " + this.getTrainNumber() + " время отправления: " + this.getDepartureTime().toString();
    }
}
