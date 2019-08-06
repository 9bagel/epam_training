package com.epam.strings_and_basics_of_text_processing.arrays;

/*
В строке найти количество цифр.
 */
public class Task3 {
    public static void main(String[] args) {

    }

    private static int findDigitsCount(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        int digitsCount = 0;
        char[] symbols = text.toCharArray();

        for (char symbol : symbols) {
            if (Character.isDigit(symbol)) {
                digitsCount++;
            }
        }
        return digitsCount;
    }

}
