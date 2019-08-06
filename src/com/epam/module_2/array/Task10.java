package com.epam.module_2.array;

/*
Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */

public class Task10 {

    public static void main(String[] args) {

    }

    private static void solution(int[] a) {

        for (int i = 1; i < a.length; i += 2) {
            a[i] = 0;
        }

    }
}
