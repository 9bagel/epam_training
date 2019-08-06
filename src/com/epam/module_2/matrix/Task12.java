package com.epam.module_2.matrix;

/*
 Отсортировать строки матрицы по возрастанию и убыванию значений элементов
 */

public class Task12 {

    public static void main(String[] args) {
    }

    private static void solution(double[][] matrix) {

//Сортировка по возрастанию
        for (int i = 0; i < matrix.length; i++) {
            double temp;
            boolean isSorted = false;

            while (!isSorted) {
                isSorted = true;
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[j][i] > matrix[j + 1][i]) {
                        isSorted = false;
                        temp = matrix[j][i];
                        matrix[j][i] = matrix[j + 1][i];
                        matrix[j + 1][i] = temp;
                    }
                }
            }

        }

//Сортировка по убыванию
        for (int i = 0; i < matrix.length; i++) {
            double temp;
            boolean isSorted = false;

            while (!isSorted) {
                isSorted = true;
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[j][i] < matrix[j + 1][i]) {
                        isSorted = false;
                        temp = matrix[j][i];
                        matrix[j][i] = matrix[j + 1][i];
                        matrix[j + 1][i] = temp;
                    }
                }
            }

        }
    }


}

