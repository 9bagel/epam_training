package com.epam.module_2.array;

/*
В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

    }

    private static void solution(int[] a, int k) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] % k == 0) {
                sum += a[i];
            }
        }

        System.out.println(sum);
    }
}
