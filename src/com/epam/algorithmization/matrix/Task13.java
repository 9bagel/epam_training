package com.epam.algorithmization.matrix;

/*
Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
 */

public class Task13 {

    public static void main(String[] args) {
    }

    //Сортировка по возрастанию
    private static void sortAscending(double[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            double temp;
            boolean isSorted = false;

            while (!isSorted) {
                isSorted = true;
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] > matrix[i][j + 1]) {
                        isSorted = false;
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i][j + 1];
                        matrix[i][j + 1] = temp;
                    }
                }
            }

        }
    }

    //Сортировка по убыванию
    private static void sortDescending(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            double temp;
            boolean isSorted = false;

            while (!isSorted) {
                isSorted = true;
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] < matrix[i][j + 1]) {
                        isSorted = false;
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i][j + 1];
                        matrix[i][j + 1] = temp;
                    }
                }
            }

        }
    }


}

