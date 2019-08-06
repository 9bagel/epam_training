package com.epam.module_2.array;

/*
В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
чисел несколько, то определить наименьшее из них.
 */

public class Task9 {

    public static void main(String[] args) {

    }

    //Костыль, здесь бы коллекции пригодились.
    private static void solution(int[] a) {
        int[] numOfRepeats = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                if (a[i] == a[j]) {
                    numOfRepeats[i]++;
                }
            }
        }

        int maxRepeatsCounter = numOfRepeats[0];
        int minRepeatsValue = a[0];

        for (int i = 1; i < numOfRepeats.length; i++) {

            if (numOfRepeats[i] > maxRepeatsCounter) {
                maxRepeatsCounter = numOfRepeats[i];
                minRepeatsValue = a[i];
            }

            if (numOfRepeats[i] == maxRepeatsCounter && a[i] < minRepeatsValue) {
                minRepeatsValue = a[i];
            }
        }

        System.out.println(minRepeatsValue);

    }
}
