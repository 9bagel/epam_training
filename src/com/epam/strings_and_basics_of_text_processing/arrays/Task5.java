package com.epam.strings_and_basics_of_text_processing.arrays;
/*
Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
Крайние пробелы в строке удалить.
 */
public class Task5 {
    public static void main(String[] args) {
        String line = "            What     a nice       day!   ";
        System.out.println(removeSpaces(line));
    }

    private static String removeSpaces(String text) {
        text = text.replaceAll(" {2,}", " ").trim();

        return text;
    }
}
