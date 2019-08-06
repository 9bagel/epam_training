package com.epam.module_2.matrix;
/*
Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
единиц равно номеру столбца.
 */


import java.util.Arrays;

public class Task14 {
    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        int n = (int) (Math.random() * 100);
        int m = (int) (Math.random() * 100);
        int[][] matrix = new int[n][m];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                matrix[i][j] = 1;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


}
