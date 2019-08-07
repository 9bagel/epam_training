package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
длинных слов может быть несколько, не обрабатывать.
   */

import java.util.Comparator;
import java.util.stream.Stream;

public class Task8 {
    public static void main(String[] args) {
        System.out.println(findLongestWord("Вводится строка слов, разделенных пробелами.  gfgdfgfdgdfgdfgdfg Найти самое длинное слово и вывести его на экран. Случай, когда самых\n" +
                "длинных слов может быть несколько, не обрабатывать."));
    }

    private static String findLongestWord(String text) {
        String[] words = text.split(" ");
        String longestWord;
        //Находим самое длинное слово через стримы
        longestWord = Stream.of(words).max(Comparator.comparing(String::length)).get();

        return longestWord;
    }

}
