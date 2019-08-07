package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
  Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
def", то должно быть выведено "abcdef".
   */

public class Task7 {
    public static void main(String[] args) {
        System.out.println(removeDuplicateSymbolsAndSpaces("abc cde def"));
    }

    private static String removeDuplicateSymbolsAndSpaces(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);

        for (int i = 0; i < stringBuilder.length(); i++) {
            char testingChar = stringBuilder.charAt(i);

            for (int j = i + 1; j < stringBuilder.length(); j++) {

                if (stringBuilder.charAt(j) == testingChar) {
                    stringBuilder.deleteCharAt(j);
                }
            }

        }
//Удаляем единственный пробел, который может остаться после.
        stringBuilder.deleteCharAt(stringBuilder.indexOf(" "));

        return String.valueOf(stringBuilder);
    }

}
