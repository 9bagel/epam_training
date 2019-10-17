package com.epam.algorithmization.matrix;
/*
Найдите наибольший элемент матрицы и заменить все нечетные элементы на него
 */


public class Task15 {
    public static void main(String[] args) {
    }

    private static void solution(double[][] matrix) {
        double max = matrix[0][0];

//Находим max значение
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }


        }

//Заменяем нечётные элементы на max
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 != 0) {
                    matrix[i][j] = max;
                }
            }
        }
    }


}
