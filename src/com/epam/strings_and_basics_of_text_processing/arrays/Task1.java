package com.epam.strings_and_basics_of_text_processing.arrays;

import java.util.Arrays;

/*
 Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println(createSnakeCase("camelCaseHugeAmountBlaBla"));
    }

    private static String createSnakeCase(String camelCase) {

        if (camelCase.isEmpty()) {
            return null;
        }

        String snakeCase;
        char[] camelCaseSymbols = camelCase.toCharArray();
        int upperCaseCount = findUpperCaseCount(camelCaseSymbols);
        char[] snakeCaseSymbols = new char[camelCaseSymbols.length + upperCaseCount];

        for (int i = 0, j = 0; i < camelCaseSymbols.length; i++, j++) {
            if (Character.isUpperCase(camelCaseSymbols[i])) {
                snakeCaseSymbols[j] = '_';
                snakeCaseSymbols[++j] = Character.toLowerCase(camelCaseSymbols[i]);
            } else {
                snakeCaseSymbols[j] = camelCaseSymbols[i];
            }
        }

        snakeCase = new String(snakeCaseSymbols);

        return snakeCase;
    }

    private static int findUpperCaseCount(char[] symbols) {
        int upperCaseCount = 0;

        for (char symbol : symbols) {
            if (Character.isUpperCase(symbol)) {
                upperCaseCount++;
            }
        }

        return upperCaseCount;
    }

}
