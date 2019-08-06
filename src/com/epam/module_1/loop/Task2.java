package com.epam.module_1.loop;

/*
Вычислить значения функции на отрезке [а,b] c шагом h:
 */

public class Task2 {
    public static void main(String[] args) {

    }

    private static void solution(int a, int b, int h) {

        for (int x = a; x < b; x += h) {
            if (x > 2) {
                System.out.println(x);

            } else System.out.println(-x);
        }
    }
}
