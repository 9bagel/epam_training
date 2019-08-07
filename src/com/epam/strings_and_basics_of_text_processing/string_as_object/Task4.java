package com.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
  */

public class Task4 {
    public static void main(String[] args) {
        System.out.println(wordTransformation("информатика"));
    }

    private static String wordTransformation(String text) {
        String resultText = "";

        if (text.contains("т") && text.contains("о") && text.contains("р")) {
            resultText = resultText.concat(String.copyValueOf(text.toCharArray(), text.indexOf('т'), 1));
            resultText = resultText.concat(String.copyValueOf(text.toCharArray(), text.indexOf('о'), 1));
            resultText = resultText.concat(String.copyValueOf(text.toCharArray(), text.indexOf('р'), 1));
            resultText = resultText.concat(String.copyValueOf(text.toCharArray(), text.indexOf('т'), 1));
        }

        return resultText;

    }
}
