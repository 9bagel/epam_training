package com.epam.basics_of_software_code_development.loop;

/*
 Найти сумму квадратов первых ста чисел.
 */

public class Task3 {
    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        int sum = 1;

        for (int i = 2; i <= 100; i++) {
            sum += i * i;
        }

        System.out.println(sum);
    }
}
