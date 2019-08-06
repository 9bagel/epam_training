package com.epam.module_2.decomposition;

/*
 Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class Task11 {
    public static void main(String[] args) {
        System.out.println(whatNumberIsLonger(1000, 3433));
    }

    private static int whatNumberIsLonger(int firstNumber, int secondNumber) {
        int firstNumberLength = 0;
        int secondNumberLength = 0;
        int tmp = firstNumber;

        while (tmp != 0) {
            firstNumberLength++;
            tmp /= 10;
        }

        tmp = secondNumber;
        while (tmp != 0) {
            secondNumberLength++;
            tmp /= 10;
        }

        if (firstNumberLength > secondNumberLength) {
            return firstNumber;
        } else return secondNumber;
    }
}
