package com.epam.basic_of_oop.calendar;

/*
Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях.

 */
public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        Calendar.Holiday halloween = calendar.new Holiday("Halloween", 15, 11);
        Calendar.Holiday newYear = calendar.new Holiday("New Year", 1, 11);
        Calendar.Holiday weekend = calendar.new Holiday("Weekend", 15, 7);

        calendar.addHoliday(halloween);
        calendar.addHoliday(newYear);
        calendar.addHoliday(weekend);

        calendar.print();

        calendar.removeHoliday("Halloween");

        calendar.removeHoliday(15, 7);

        calendar.print();
    }
}
