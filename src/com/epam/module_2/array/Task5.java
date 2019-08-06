package com.epam.module_2.array;

/*
Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 */

public class Task5 {

    public static void main(String[] args) {

    }

    private static void solution(int[] a) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] > i) {
                System.out.println(a[i]);
            }
        }

    }
}
