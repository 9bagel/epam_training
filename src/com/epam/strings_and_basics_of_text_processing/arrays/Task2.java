package com.epam.strings_and_basics_of_text_processing.arrays;

/*
 Замените в строке все вхождения 'word' на 'letter'.
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println(replaceWord("fdlfjkword fjd word fdwor d word worf fd"));
    }

    private static String replaceWord(String text) {

        text = text.replaceAll("word", "letter");

        return text;
    }

}
