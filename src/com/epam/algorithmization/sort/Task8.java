package com.epam.algorithmization.sort;

/*
Даны дроби. Составить программу, которая приводит эти дроби к общему
знаменателю и упорядочивает их в порядке возрастания.
 */
public class Task8 {
    public static void main(String[] args) {
        int[] numeratorsArray = {1, 2, 6, 8, 8, 8, 9, 11};
        int[] denominatorsArray = {2, 3, 6, 7, 8, 10, 11, 9};
        solution(numeratorsArray, denominatorsArray);
    }

    /*
    1) Находим наибольшее из знаменателей
    2) Если max поделился нацело на все знаменатели мы нашли НОК переход к 4
    3) Иначе последовательно умножаем max на i (i=1..бесконечность)пока он
    нацело не будет делится на все знаменатели.
    4) Возвращаем наименьшее общее кратное
     */
    private static void solution(int[] numeratorsArray, int[] denominatorsArray) {
        int nok = findNok(denominatorsArray);

        for (int i = 0; i < numeratorsArray.length; i++) {
            numeratorsArray[i] = nok / denominatorsArray[i] * numeratorsArray[i];
        }
        sort(numeratorsArray);

        for (int i = 0; i < numeratorsArray.length; i++) {
            System.out.print(numeratorsArray[i] + "/" + nok + "\t");
        }

    }

    private static int findNok(int[] denominatorsArray) {
        int maxDenominator = denominatorsArray[0];

        for (int i = 1; i < denominatorsArray.length; i++) {
            if (maxDenominator < denominatorsArray[i]) {
                maxDenominator = denominatorsArray[i];
            }
        }
        boolean isNOKFound = false;

        int nok = maxDenominator;
        int multiplier = 1;
        while (!isNOKFound) {
            nok = maxDenominator * multiplier;
            isNOKFound = true;
            for (int i = 0; i < denominatorsArray.length; i++) {
                if (nok % denominatorsArray[i] != 0) {
                    isNOKFound = false;
                }

            }
            multiplier++;
        }
        System.out.println("НОК - " + nok);
        return nok;
    }

    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[maxIndex]) {
                    maxIndex = j;
                }

                if (maxIndex != i) {
                    int tmp = array[i];
                    array[i] = array[maxIndex];
                    array[maxIndex] = tmp;
                }
            }
        }
        return array;
    }
}
