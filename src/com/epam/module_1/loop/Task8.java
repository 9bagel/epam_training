package com.epam.module_1.loop;

/*
Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */

public class Task8 {
    public static void main(String[] args) {

    }

    private static void solution(int a, int b) {

        char[] charsOfA = String.valueOf(a).toCharArray();
        char[] charsOfB = String.valueOf(b).toCharArray();

        for (int i = 0; i < charsOfA.length - 1; i++) {

            for (int j = 0; j < charsOfB.length - 1; j++) {

                if (charsOfA[i] == charsOfB[j]) {

                    System.out.print(charsOfA[i] + " ");
                }
            }
        }
    }
}