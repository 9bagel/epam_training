package com.epam.basics_of_software_code_development.loop;

/*
Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры.
 */

import java.util.Scanner;

public class Task7 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        for (int i = m; i <= n; i++) {
            int tmp = 0;

            System.out.printf("Для %d делители:\n", i);

            for (int j = 2; j < i - 1; j++) {

                if (i % j == 0) {

                    System.out.println(j);
                    tmp = 1;
                }
            }
            if (tmp == 0) {
                System.out.println("Отсутствуют");
            }
        }
    }
}
