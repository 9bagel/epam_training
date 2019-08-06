package com.epam.module_2.decomposition;

import java.util.Arrays;

/*
 Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
являются цифры числа N.
 */
public class Task10 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(creatAnArrayFromNumber(459098765)));
    }

    private static int[] creatAnArrayFromNumber(int number) {
        int arraySize = 0;
        int[] array;

        int tmp = number;
//Определяем какого размера необходим массив
        while (tmp != 0) {
            arraySize++;
            tmp /= 10;
        }

        array = new int[arraySize];

        while (number != 0) {
            array[--arraySize] = number % 10;
            number /= 10;
        }
        return array;
    }
}
