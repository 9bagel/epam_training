package com.epam.algorithmization.decomposition;

/*
Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */

public class Task16 {
    public static void main(String[] args) {
        int sum = findSumOfOddNumbers(7);
        System.out.println("Сумма = " + sum);

        int evenDigitsCount = findEvenDigitsCount(sum);

        System.out.println("Число чётных цифр в сумме = " + evenDigitsCount);
    }

    private static int findSumOfOddNumbers(int n) {
        int startNumber = (int) Math.pow(10, n - 1);
        int sumOfOddNumbers = 0;

        for (int number = startNumber; number < startNumber * 10; number++) {
            int tmp = number;
            int numberLength = findNumberLength(number);

            while (tmp != 0) {
                if ((tmp % 10) % 2 != 0) {
                    numberLength--;
                }
                tmp /= 10;
            }

            if (numberLength == 0) {
                sumOfOddNumbers += number;
            }
        }
        return sumOfOddNumbers;
    }

    private static int findNumberLength(int number) {
        int numberLength = 0;

        while (number != 0) {
            numberLength++;
            number /= 10;
        }
        return numberLength;
    }

    private static int findEvenDigitsCount(int number) {
        int evenDigitsCount = 0;

        int numberLength = findNumberLength(number);

        for (int i = 1; i <= numberLength; i++) {
            int digit = (int) (number / Math.pow(10, i - 1)) % 10;

            if (digit % 2 == 0) {
                evenDigitsCount++;
            }
        }

        return evenDigitsCount;
    }

}
