package com.epam.module_2.array;

/*
Дана последовательность целых чисел.
Образовать новую последовательность, выбросив из
исходной те члены, которые равны...
 */

public class Task8 {

    public static void main(String[] args) {

    }

    private static void solution(int[] a) {

        int min = a[0];

        for (int i = 1; i < a.length; i++) {

            if (min > a[i]) {
                min = a[i];
            }
        }

        int[] newArray = new int[a.length];

        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[i] != min) {
                newArray[j] = a[i];
                j++;
            }
        }

    }
}
