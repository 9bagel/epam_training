package com.epam.module_2.sort;

import java.util.Arrays;

/*
Пусть даны две неубывающие последовательности действительных чисел
Требуется указать те места, на которые нужно вставлять элементы последовательности в первую
последовательность так, чтобы новая последовательность оставалась возрастающей
 */
public class Task7 {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, 6, 8, 8, 8, 9, 11, 12, 13, 14, 16};
        int[] secondArray = {2, 3, 6, 7, 8, 10, 11, 17, 18, 19, 20};

        solution(firstArray, secondArray);
    }

    private static void solution(int[] firstArray, int[] secondArray) {
        int[] resultArray = new int[firstArray.length + secondArray.length];

        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int resultArrayIndex = 0;

        while (resultArrayIndex < resultArray.length) {

            if (firstArrayIndex < firstArray.length && secondArrayIndex < secondArray.length) {
                if (firstArray[firstArrayIndex] < secondArray[secondArrayIndex]) {

                    resultArray[resultArrayIndex] = firstArray[firstArrayIndex];
                    firstArrayIndex++;

                } else {
                    resultArray[resultArrayIndex] = secondArray[secondArrayIndex];
                    System.out.printf("Вставили значение %d из второго массива на место индекса %d" + "\n", secondArray[secondArrayIndex], resultArrayIndex);
                    secondArrayIndex++;
                }
            } else if (firstArrayIndex < firstArray.length) {
                resultArray[resultArrayIndex] = firstArray[firstArrayIndex];
                firstArrayIndex++;
            } else {
                resultArray[resultArrayIndex] = secondArray[secondArrayIndex];
                System.out.printf("Вставили значение %d из второго массива в конец первого" + "\n", secondArray[secondArrayIndex]);
                secondArrayIndex++;
            }

            resultArrayIndex++;
        }

        System.out.println("result: " + Arrays.toString(resultArray));
    }
}

