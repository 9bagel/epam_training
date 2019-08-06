package com.epam.algorithmization.sort;

import java.util.Arrays;

//Сортировка выбором.
public class Task3 {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, 6, 8, 8, 8, 9, 11, 12, 13, 14, 16};
        solution(firstArray);
    }

    private static void solution(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }

                if (maxIndex != i) {
                    int tmp = array[i];
                    array[i] = array[maxIndex];
                    array[maxIndex] = tmp;
                }
            }
        }
        System.out.println("result: " + Arrays.toString(array));
    }

}
