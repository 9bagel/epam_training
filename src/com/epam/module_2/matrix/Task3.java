package com.epam.module_2.matrix;

/*
 Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

public class Task3 {

    public static void main(String[] args) {

    }

    private static void solution(int[][] a, int k, int p) {
        //Вывод к-ой строки
        for (int i = 0; i < a[k].length; i++) {
            System.out.println(a[k][i]);
        }

        //Вывод p-го столбца
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][p]);
        }
    }
}
