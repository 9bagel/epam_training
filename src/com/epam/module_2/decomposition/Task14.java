package com.epam.module_2.decomposition;

/*
Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
использовать декомпозицию.
 */

import java.util.Arrays;

public class Task14 {
    public static void main(String[] args) {
        printArray(findArmstrongNumbers(200000));
    }

    private static int[] findArmstrongNumbers(int k) {
        int[] array = new int[findArrayLength(k)];
        for (int i = 1, j = 0; i < k; i++) {
            int tmp = i;
            int numberLength = 0;
            int tmpSum = 0;

            while (tmp != 0) {
                tmpSum += tmp % 10;
                tmp /= 10;
                numberLength++;
            }

            if (Math.pow(tmpSum, numberLength) == i) {
                array[j] = i;
                j++;
            }
        }
        return array;
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static int findArrayLength(int k) {
        int arrayLength = 0;
        for (int i = 1; i < k; i++) {
            int tmp = i;
            int numberLength = 0;
            int tmpSum = 0;

            while (tmp != 0) {
                tmpSum += tmp % 10;
                tmp /= 10;
                numberLength++;
            }

            if (Math.pow(tmpSum, numberLength) == i) {
                arrayLength++;
            }
        }
        return arrayLength;
    }

}
