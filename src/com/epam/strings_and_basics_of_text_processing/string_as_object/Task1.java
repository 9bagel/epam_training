package com.epam.strings_and_basics_of_text_processing.string_as_object;

public class Task1 {
    public static void main(String[] args) {

    }

    private static int findMaxSpaceCount(String text) {

        int maxSpaceCount = 0;
        int tmpSpaceCount = 0;
        StringBuilder stringBuilder = new StringBuilder(text);

        for (int i = 0; i < stringBuilder.length(); i++) {

            if (stringBuilder.charAt(i) == ' ') {
                tmpSpaceCount++;

            } else if (stringBuilder.charAt(i) != ' ') {
                maxSpaceCount = Math.max(tmpSpaceCount, maxSpaceCount);
                tmpSpaceCount = 0;
            }
        }

        return maxSpaceCount;
    }
}
