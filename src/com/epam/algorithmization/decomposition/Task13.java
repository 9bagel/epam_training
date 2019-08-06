package com.epam.algorithmization.decomposition;

/*
Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
решения задачи использовать декомпозицию.
 */

public class Task13 {
    public static void main(String[] args) {
        int[] array = findTwins(15);

        printArray(array);
    }

    private static int[] findTwins(int n) {
        int[] array = new int[2 * n - 4];

        for (int i = n, j = 0; i < 2 * n; i++, j = j + 2) {
            if (i + 2 < 2 * n) {
                array[j] = i;
                array[j + 1] = i + 2;
            }
        }
        return array;
    }

    private static void printArray(int[] array) {

        for (int i = 0; i < array.length; i += 2) {
            if (i + 1 < array.length) {
                System.out.println(array[i] + " - " + array[i + 1]);
            }
        }
    }

}
