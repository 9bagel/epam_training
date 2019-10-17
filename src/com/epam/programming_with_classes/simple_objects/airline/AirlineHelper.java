package com.epam.programming_with_classes.simple_objects.airline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

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
public class AirlineHelper {

    private Airline[] airlines = createAirLines();

    public void printByDestinationName(String destinationName) {
        Stream.of(airlines).filter(airline -> airline.getDestination().equals(destinationName)).forEach(System.out::println);
    }

    public void printByDayOfWeek(Enum<DayOfWeek> dayOfWeekEnum) {
        Stream.of(airlines).filter(airline -> airline.getDayOfWeek().equals(dayOfWeekEnum)).forEach(System.out::println);
    }

    public void printByDayOfWeekAndTime(Enum<DayOfWeek> dayOfWeekEnum, String time) {

        Date date = null;
        try {
            date = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalDate = date;
        Stream.of(airlines).filter(airline -> airline.getDayOfWeek()
                .equals(dayOfWeekEnum)
                && airline.getDepartureTime()
                .after(finalDate))
                .forEach(System.out::println);
    }

    private Airline[] createAirLines() {

        Airline[] airlines = new Airline[5];

        airlines[0] = new Airline("Paris", 345, AircraftType.HEAVY, "23 00", DayOfWeek.SATURDAY);
        airlines[1] = new Airline("Berlin", 23, AircraftType.LIGHT, "24 30", DayOfWeek.SATURDAY);
        airlines[2] = new Airline("Moscow", 11, AircraftType.MEDIUM, "23 30", DayOfWeek.THURSDAY);
        airlines[3] = new Airline("Paris", 34, AircraftType.SUPERHEAVY, "23 00", DayOfWeek.WEDNESDAY);
        airlines[4] = new Airline("Paris", 54, AircraftType.SUPERLIGHT, "23 00", DayOfWeek.FRIDAY);

        return airlines;
    }


}
