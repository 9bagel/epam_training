package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
В строке вставить после каждого символа 'a' символ 'b'.
 */

public class Task2 {
    public static void main(String[] args) {
        System.out.println(addSymbols("ahbfh bdhsaqa as af af jakj a"));
    }

    private static String addSymbols(String text) {

        StringBuilder stringBuilder = new StringBuilder(text);

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == 'a')
                stringBuilder.insert(i + 1, 'b');
        }

        return String.valueOf(stringBuilder);
    }
}
