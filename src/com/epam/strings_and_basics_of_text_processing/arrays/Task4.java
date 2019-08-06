package com.epam.strings_and_basics_of_text_processing.arrays;

/*
В строке найти количество чисел
 */
public class Task4 {
    public static void main(String[] args) {
        System.out.println(findNumbersCount("f8 h8fdhfh h 78fh uhuih87ih83h8f9 h7f3gf397iuf3 hif3uf389hui fd87 78 9"));
    }

    private static int findNumbersCount(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        String[] numbersArray = text.split("\\D");

        int numbersCount = 0;

        for (String number : numbersArray) {
            if (number.length() != 0) {
                numbersCount++;
            }
        }
        return numbersCount;
    }

}
