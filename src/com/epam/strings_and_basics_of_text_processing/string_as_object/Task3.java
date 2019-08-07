package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 Проверить, является ли заданное слово палиндромом.
 */

public class Task3 {
    public static void main(String[] args) {

    }

    private static boolean isPalindrome(String text) {

        String reverseText = new StringBuilder(text).reverse().toString();

        return reverseText.equalsIgnoreCase(text);
    }
}
