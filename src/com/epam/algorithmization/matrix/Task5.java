package com.epam.algorithmization.matrix;

/*
Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Task5 {

    public static void main(String[] args) {
    }

    private static void solution(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                matrix[i][j] = i + 1;
            }
        }
    }
}
