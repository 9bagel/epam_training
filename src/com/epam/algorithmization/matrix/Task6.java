package com.epam.algorithmization.matrix;

/*
Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Task6 {

    public static void main(String[] args) {
        solution(20);
    }

    private static void solution(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            if (i <= (matrix.length - 1) / 2) {
                for (int j = i; j < matrix[i].length - i; j++) {

                    matrix[i][j] = 1;
                }
            } else {
                for (int j = matrix[i].length - i - 1; j < i + 1; j++) {
                    matrix[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

