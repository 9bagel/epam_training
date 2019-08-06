package com.epam.module_1.condition;

/*
Найти max{min(a, b), min(c, d)}
 */

public class Task2 {

    public static void main(String[] args) {
        solution(5, 7, -2, 9);
    }

    private static void solution(int a, int b, int c, int d) {
        int minOfAB = (a < b) ? a : b;

        int minofCD = (c < d) ? c : d;

        int max = (minOfAB > minofCD) ? minOfAB : minofCD;

        System.out.println(max);
    }
}
