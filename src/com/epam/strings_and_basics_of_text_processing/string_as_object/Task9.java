package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
буквы.
   */

public class Task9 {
    public static void main(String[] args) {

    }

    private static int findLowerCaseCount(String text) {
        int lowerCaseCount = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                lowerCaseCount++;
            }
        }

        return lowerCaseCount;
    }

    private static int findUpperCaseCount(String text) {
        int upperCaseCount = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                upperCaseCount++;
            }
        }

        return upperCaseCount;
    }

}
