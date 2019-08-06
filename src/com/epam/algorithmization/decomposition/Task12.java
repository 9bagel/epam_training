package com.epam.algorithmization.decomposition;

/*
Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
являются числа, сумма цифр которых равна К и которые не большее N.
 */

public class Task12 {
    public static void main(String[] args) {
    }

    private static int[] creatArray(int numbersSum, int maxValue, int arraySize) {
        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            int cheakSum = 0;
            array[i] = (int) (Math.random() * maxValue);
            int cheakNum = array[i];
            do {
                cheakSum += cheakNum % 10;
                cheakNum /= 10;

            } while (cheakNum > 0);

            if (cheakSum != numbersSum) {
                i--;
            }
        }
        return array;
    }

}
