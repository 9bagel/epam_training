package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 Из заданной строки получить новую, повторив каждый символ дважды.
   */

public class Task6 {
    public static void main(String[] args) {
        System.out.println(doubleEveryChar(" Подсчитать, сколько раз среди символов заданной строки встречается буква “а”"));
    }

    private static String doubleEveryChar(String text) {

        if (text.isEmpty()) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringBuilder.length(); i++) {

            result.append(stringBuilder.charAt(i));
            result.append(stringBuilder.charAt(i));
        }

        return String.valueOf(result);
    }
}
