package com.epam.module_2.decomposition;

/*
 Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
массива с номерами от k до m.
 */
public class Task8 {
    public static void main(String[] args) {

    }

    private static double findSumOfThree(int startPoint, int endPoint, double[] array) {
        double sum = 0;
        for (int i = startPoint; i <= endPoint; i++) {
            sum += array[i];
        }
        return sum;
    }
}
