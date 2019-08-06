package com.epam.module_2.decomposition;

/*
Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
натуральных чисел:
 */

public class Task1 {
    public static void main(String[] args) {

    }

    //Алгоритм Евклида
    /*
1)Большее число делим на меньшее.
2)Если делится без остатка, то меньшее число и есть НОД (следует выйти из цикла).
3)Если есть остаток, то большее число заменяем на остаток от деления.
4)Переходим к пункту 1.
     */
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

    private static int findNOK(int firstNumber, int secondNumber) {
        int nod = findNOD(firstNumber, secondNumber);

        return firstNumber * secondNumber / nod;
    }
}
