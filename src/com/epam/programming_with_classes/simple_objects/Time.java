package com.epam.programming_with_classes.simple_objects;

/*
Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
заданное количество часов, минут и секунд.
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour) {

        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            this.hour = 0;
            System.out.println("Установлено значение 0");
        }
    }

    public void setMinute(int minute) {

        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            this.minute = 0;
            System.out.println("Установлено значение 0");
        }
    }

    public void setSecond(int second) {

        if (second >= 0 && second < 60) {
            this.second = second;
        } else {
            this.second = 0;
            System.out.println("Установлено значение 0");
        }
    }

    public void changeHour(int hours) {

        if (this.hour + hours >= 0) {
            this.hour += hours;
        } else {
            System.out.println("Так изменить часы нельзя");
        }
    }

    public void changeMinute(int minutes) {

        this.minute += minutes;

        while (this.minute >= 59) {

            changeHour(1);
            this.minute -= 60;
        }
    }

    public void changeSecond(int seconds) {

        this.second += seconds;

        while (this.second >= 60) {

            changeMinute(1);
            this.second -= 60;
        }

    }
}
