package com.epam.algorithmization.decomposition;

/*
Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 */

public class Task15 {
    public static void main(String[] args) {
        findGrowingNumbers(3);
    }

    private static void findGrowingNumbers(int n) {
        int starValue = (int) Math.pow(10, n - 1);

        for (int i = starValue; i < starValue * 10; i++) {
            int growingNumbersCount = 0;

            for (int j = 1; j < n; j++) {

                int rightDigit = (int) (i / Math.pow(10, j - 1)) % 10;
                int leftDigit = (int) (i / Math.pow(10, j)) % 10;

                if (leftDigit < rightDigit) {
                    growingNumbersCount++;
                }
                if (growingNumbersCount == n - 1) {
                    System.out.println(i);
                }
            }
        }
    }

}
