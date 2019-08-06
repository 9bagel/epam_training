package com.epam.algorithmization.array;

/*
Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
числом. Подсчитать количество замен.
 */

public class Task2 {

    public static void main(String[] args) {

    }

    private static void solution(int[] a, int z) {
        int countOfReplacements = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] > z) {
                a[i] = z;
                countOfReplacements++;
            }
        }

        System.out.println(countOfReplacements);
    }
}
