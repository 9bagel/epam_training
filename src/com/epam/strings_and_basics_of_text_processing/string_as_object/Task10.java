package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
знаком. Определить количество предложений в строке X.
   */

public class Task10 {
    public static void main(String[] args) {
        System.out.println(findCountOfSentence("Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным\n" +
                "знаком. Определить количество предложений в строке X."));
    }

    private static int findCountOfSentence(String text) {
        int countOfSentence = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                countOfSentence++;
            }
        }

        return countOfSentence;
    }

}
