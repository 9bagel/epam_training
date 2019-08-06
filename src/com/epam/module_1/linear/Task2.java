package com.epam.module_1.linear;

import java.util.Scanner;

/*
Вычислить значение выражения по формуле (все переменные принимают действительные значения):
𝑏 + √𝑏
2 + 4𝑎𝑐
2𝑎
− 𝑎
3
𝑐 + 𝑏
−2
 */
public class Task2 {
    public static void main(String[] args) {

        solution();
    }

    private static double solution() {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        return (b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) - (Math.pow(a, 3) * c + Math.pow(b, -2));
    }
}
