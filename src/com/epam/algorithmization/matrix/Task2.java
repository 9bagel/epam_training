package com.epam.algorithmization.matrix;

/*
Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали
 */

public class Task2 {

    public static void main(String[] args) {

    }

    private static void solution(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][i]);
        }
    }
}
