package com.epam.module_1.loop;

/*
 Составить программу нахождения произведения квадратов первых двухсот чисел.
 */

public class Task4 {
    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        int sum = 1;

        for (int i = 2; i <= 200; i++) {
            sum *= i * i;
        }
        System.out.println(sum);
    }
}
