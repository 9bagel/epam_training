package com.epam.basics_of_software_code_development.loop;

/*
Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
все числа от 1 до введенного пользователем числа.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
    }

    private static void solution() {

        int sum = 0;
        int i = readInput();

        for (int j = 1; j < i; j++) {
            sum += j;
        }

        System.out.println(sum);
    }

    private static int readInput() {

        Scanner scanner = new Scanner(System.in);
        int i = 0;

        do {
            System.out.println("Введите целое положительное число");

            while (!scanner.hasNextInt()) {
                System.out.println("Не число");
                scanner.next();
            }

            i = scanner.nextInt();

        } while (i <= 0);

        return i;
    }

}
