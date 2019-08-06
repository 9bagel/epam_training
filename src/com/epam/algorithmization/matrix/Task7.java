package com.epam.algorithmization.matrix;

/*
Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Task7 {

    public static void main(String[] args) {
        solution(20);
    }

    private static void solution(int n) {
        double[][] matrix = new double[n][n];
        int positivesCounter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.sin((i * i - (j * j)) / n);

                if (matrix[i][j] > 0) {
                    positivesCounter++;
                }
            }
        }
        System.out.println(positivesCounter);
    }

}

