package com.epam.module_2.array;

/*
Даны действительные числа
a a an
, , ,
1 2 
. Найти
max( , , , ) a1 + a2n a2 + a2n−1  an + an+1
.
 */

public class Task7 {

    public static void main(String[] args) {

    }

    private static void solution(double[] a) {
        int n = a.length / 2;
        double max = a[0] + a[n * 2 - 1];

        for (int i = 1; i <= n; i++) {
            double tmp = a[i] + a[n * 2 - 1];

            if (tmp > max) {
                max = tmp;
            }
        }
        System.out.println(max);

    }
}
