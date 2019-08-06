package com.epam.algorithmization.matrix;

/*
 Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class Task10 {

    public static void main(String[] args) {
    }

    private static void solution(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] > 0) {
                System.out.println(matrix[i][i]);
            }
        }
    }

}

