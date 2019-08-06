package com.epam.algorithmization.matrix;

/*
Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
которых число 5 встречается три и более раз.
 */

public class Task11 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        int[][] matrix = new int[10][20];

        for (int i = 0; i < matrix.length; i++) {
            int countOfFives = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 16);

                if (matrix[i][j] == 5) {
                    countOfFives++;
                }

                System.out.print(matrix[i][j] + "\t");

            }
            System.out.println();
            if (countOfFives >= 3) {
                System.out.println(i);
            }
        }
    }

}

