package com.epam.algorithmization.matrix;

/*
 Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Task4 {

    public static void main(String[] args) {
        solution(10);
    }

    private static void solution(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = j + 1;
                matrix[i + 1][j] = n - j;
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
