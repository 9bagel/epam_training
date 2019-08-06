package com.epam.algorithmization.sort;

import java.util.Arrays;

/*
Даны две последовательности
a1  a2  an и b1  b2  bm
. Образовать из них новую последовательность
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать
 */
public class Task2 {
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
                    secondArrayIndex++;
                }
            } else if (firstArrayIndex < firstArray.length && secondArrayIndex >= secondArray.length) {
                resultArray[resultArrayIndex] = firstArray[firstArrayIndex];
                firstArrayIndex++;
            } else {
                resultArray[resultArrayIndex] = secondArray[secondArrayIndex];
                secondArrayIndex++;
            }

            resultArrayIndex++;
        }

        System.out.println("result: " + Arrays.toString(resultArray));
    }
}
