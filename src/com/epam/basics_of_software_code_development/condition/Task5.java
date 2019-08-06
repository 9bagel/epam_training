package com.epam.basics_of_software_code_development.condition;

/*
 Вычислить значение функции:
 */

public class Task5 {
    public static void main(String[] args) {

    }

    private static void solution(int x) {
        double func;

        if (x <= 3) {
            func = x * x - (3 * x) + 9;

        } else func = 1 / (Math.pow(x, 3) + 3);

        System.out.println(func);
    }
}
