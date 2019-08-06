package com.epam.module_2.array;

/*
Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */

public class Task4 {

    public static void main(String[] args) {

    }

    private static void solution(double[] a) {
        int indexOfMax = 0;
        int indexOfMin = 0;
        double tmp = 0;

        for (int i = 1; i < a.length; i++) {

            if (a[i] > a[indexOfMax]) {
                indexOfMax = i;
            }
            if (a[i] < a[indexOfMin]) {
                indexOfMin = i;
            }
        }
//Меняем максимальное и минимальное значения местами
        tmp = a[indexOfMax];
        a[indexOfMax] = a[indexOfMin];
        a[indexOfMin] = tmp;

    }
}
