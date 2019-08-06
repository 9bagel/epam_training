package com.epam.module_2.sort;

import java.util.Arrays;

//Сортировка Шелла
public class Task6 {
    public static void main(String[] args) {
        double[] firstArray = {1, 5, 8, 2, 18, 3, 15, 0, 10, 12};
        solution(firstArray);
    }

    private static void solution(double[] array) {
        int increment = array.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(array, startIndex, increment);
            }
            increment = increment / 2;
        }
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();

    }

    private static void insertionSort(double[] array, int startIndex, int increment) {
        for (int i = startIndex; i < array.length - 1; i = i + increment) {
            for (int j = Math.min(i + increment, array.length - 1); j - increment >= 0; j = j - increment) {
                if (array[j - increment] > array[j]) {
                    double tmp = array[j];
                    array[j] = array[j - increment];
                    array[j - increment] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}


