package com.epam.module_2.array;

/*
Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
являются простыми числами.
 */

public class Task6 {

    public static void main(String[] args) {
    }

    private static void solution(double[] n) {

        double sum = 0;
/* Тестирование работы алгоритма
        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

 */
        for (int i = 0; i < n.length; i++) {

            if (isPrime(i)) {
                sum += n[i];
            }
        }

        System.out.println(sum);
    }

    // Взял алгоритм из Вики https://en.wikipedia.org/wiki/Primality_test    Т.к. свой алгоритм неэффективный
    private static boolean isPrime(int i) {
        if (i <= 3) {
            return i > 1;
        } else if (i % 2 == 0 || i % 3 == 0) {
            return false;
        }

        int tmp = 5;

        while (tmp * tmp <= i) {
            if (i % tmp == 0 || i % (tmp + 2) == 0) {
                return false;
            }
            tmp += 6;
        }
        return true;
    }
}
