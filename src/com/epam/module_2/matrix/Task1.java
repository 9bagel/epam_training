package com.epam.module_2.matrix;

/*
Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */

public class Task1 {

    public static void main(String[] args) {

    }

    private static void solution(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j += 2) {
                if (a[0][j] > a[a.length - 1][j]) {
                    for (int k = 0; k < a.length; k++) {
                        System.out.println(a[k][j]);
                    }
                }
            }
        }

    }
}
