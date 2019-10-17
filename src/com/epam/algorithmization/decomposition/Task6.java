package com.epam.algorithmization.decomposition;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(isPrime(5, 11, 15));
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

    private static boolean isPrime(int firstNumber, int secondNumber, int thirdNumber) {
        int nod = findNOD(firstNumber, secondNumber);
        nod = findNOD(nod, thirdNumber);

        System.out.println("Nod = " + nod);

        return nod == 1;
    }
}
