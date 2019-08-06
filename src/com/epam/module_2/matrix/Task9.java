package com.epam.module_2.matrix;

/*
Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
столбец содержит максимальную сумму.
 */

public class Task9 {

    public static void main(String[] args) {
    }

    private static void solution(int[][] matrix) {

        int maxColumnNumber = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (j >= maxColumnNumber) {
                    maxColumnNumber = j + 1;
                }
            }
        }

        int[] sum = new int[maxColumnNumber];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[j] += matrix[i][j];
            }
        }

        int valueOfMaxSum = sum[0];
        maxColumnNumber = 0;
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] > valueOfMaxSum) {
                valueOfMaxSum = sum[i];
                maxColumnNumber = i;
            }
        }
        System.out.println(maxColumnNumber);
    }
}