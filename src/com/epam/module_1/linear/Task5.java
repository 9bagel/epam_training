package com.epam.module_1.linear;

/*
Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
Вывести данное значение длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc.
 */

public class Task5 {

    public static void main(String[] args) {
        solution(14535);
    }

    private static void solution(int time) {

        int hours = time / 60 / 60;
        int minutes = (time - (hours * 60 * 60)) / 60;
        int seconds = time - (hours * 60 * 60) - (minutes * 60);

        System.out.printf("%dч %dмин %dс", hours, minutes, seconds);
    }
}
