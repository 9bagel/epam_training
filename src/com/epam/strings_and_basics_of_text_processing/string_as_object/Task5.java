package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
   */

public class Task5 {
    public static void main(String[] args) {
        System.out.println(countA(" Подсчитать, сколько раз среди символов заданной строки встречается буква “а”"));
    }

    private static int countA(String text) {
        int count = 0;
        int index = text.length();
        while (--index != 0) {

            if (text.charAt(index) == 'а') {
                count++;
            }
        }

        return count;
    }
}
