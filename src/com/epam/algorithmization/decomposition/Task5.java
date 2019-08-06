package com.epam.algorithmization.decomposition;

/*
Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
которое меньше максимального элемента массива, но больше всех других элементов).
 */

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        double[] array = createNewArray();

        System.out.println("Second highest value is: " + findSecondMaxValue(array));
    }

    private static double[] createNewArray() {
        int n = (int) (Math.random() * 100);
        double[] array = new double[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }

        System.out.println("We just created an array. Look at it!");
        System.out.println(Arrays.toString(array));

        return array;
    }

    private static double findSecondMaxValue(double[] array) {
        double maxValue = array[0];
        double secondMaxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (maxValue < array[i]) {
                secondMaxValue = maxValue;
                maxValue = array[i];
            }

            if (secondMaxValue < array[i] && maxValue > array[i]) {
                secondMaxValue = array[i];
            }
        }

        return secondMaxValue;
    }
}
