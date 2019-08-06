package com.epam.module_2.decomposition;

/*
Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */

public class Task2 {
    public static void main(String[] args) {

    }
/*
НОД нескольких чисел равен числу d,которое находится при последовательном вычислении НОД
 */
    private static int findNOD(int firstNumber, int secondNumber, int thirdNumber, int forthNumber) {
        int tmpNod;

        tmpNod = findNOD(firstNumber, secondNumber);
        tmpNod = findNOD(tmpNod, thirdNumber);
        tmpNod = findNOD(tmpNod, forthNumber);

        return tmpNod;

    }

    private static int findNOD(int firstNumber, int secondNumber) {
        while (firstNumber != 0 && secondNumber != 0) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber % secondNumber;
            } else {
                secondNumber = secondNumber % firstNumber;
            }
        }
        return firstNumber + secondNumber;
    }
}
