package com.epam.module_2.sort;

/*
 Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
дополнительный массив.
 */

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] firstArray = new int[3];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = (int) (Math.random() * 10);
        }
        System.out.println("first  Array is :" + Arrays.toString(firstArray));

        int[] secondArray = new int[3];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = (int) (Math.random() * 20);
        }
        System.out.println("second Array is: " + Arrays.toString(secondArray));

        solution(firstArray, secondArray, 1);
    }

    private static void solution(int[] firstArray, int[] secondArray, int k) {

        int[] resultArray = new int[firstArray.length + secondArray.length];

        if (k >= firstArray.length - 1) {
            System.out.println("Т.к. k >= размера первого массива, то второй массив будет вставлен в конце");
            k = firstArray.length - 1;
        }

        for (int i = 0; i < firstArray.length; i++) {
            if (i == k) {
                resultArray[i] = firstArray[i];

                for (int j = 0; j < secondArray.length; j++) {
                    resultArray[i + j + 1] = secondArray[j];
                }

            } else if (i < k) {
                resultArray[i] = firstArray[i];
            } else {
                resultArray[i + secondArray.length] = firstArray[i];
            }
        }
        System.out.println("result array is" + Arrays.toString(resultArray));

    }
}
