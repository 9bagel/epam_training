package com.epam.module_2.sort;

import java.util.Arrays;

//Сортировка обменами
public class Task4 {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, 6, 8, 8, 8, 9, 11, 12, 13, 14, 16};
        solution(firstArray);
    }

    private static void solution(int[] array) {
        boolean isSorted = false;
        int swapCount = 0;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]){
                    isSorted = false;

                    int tmp = array[i];
                    array[i] = array[i +1];
                    array[i + 1] = tmp;
                    swapCount++;
                }
            }
        }
        System.out.println("result: " + Arrays.toString(array));
        System.out.println(swapCount);
    }
}

