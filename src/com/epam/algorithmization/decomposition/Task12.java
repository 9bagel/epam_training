package com.epam.algorithmization.decomposition;

/*
Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
являются числа, сумма цифр которых равна К и которые не большее N.
 */

public class Task12 {
    public static void main(String[] args) {
    }

    private static int[] createArray(int numbersSum, int maxValue, int arraySize) {

        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {

            int checkSum = 0;

            array[i] = (int) (Math.random() * maxValue);

            int checkNum = array[i];

            do {
                checkSum += checkNum % 10;
                checkNum /= 10;

            } while (checkNum > 0);

            if (checkSum != numbersSum) {
                i--;
            }
        }
        return array;
    }

}
