package com.epam.module_2.array;

/*
Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
положительных и нулевых элементов.
 */

public class Task3 {

    public static void main(String[] args) {

    }

    private static void solution(double[] a) {
        int countOfPositives = 0;
        int countOfNegatives = 0;
        int countOfZeroes = 0;

        for (int i = 0; i < a.length; i++) {
            double tmp = a[i];

            if (tmp > 0) {
                countOfPositives++;
            } else if (tmp == 0) {
                countOfZeroes++;
            } else {
                countOfNegatives++;
            }
        }

        System.out.printf("Отрицательных - %d, положительных - %d, нулей - %d", countOfNegatives, countOfPositives, countOfZeroes);
    }
}
