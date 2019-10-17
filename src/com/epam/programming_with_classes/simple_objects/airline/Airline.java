package com.epam.programming_with_classes.simple_objects.airline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.

 */
public class Airline {

    private String destination;
    private int flightNumber;
    private AircraftType aircraftType;
    private String departureTime;
    private DayOfWeek dayOfWeek;

    public static void main(String[] args) {

    }

    public Airline(String destination, int flightNumber, AircraftType aircraftType, String departureTime, DayOfWeek dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber=" + flightNumber +
                ", aircraftType=" + aircraftType +
                ", departureTime='" + departureTime + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Date getDepartureTime() {

        try {
            return new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").parse(departureTime);

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
