package com.epam.strings_and_basics_of_text_processing.regex.task1;

public class Spliter {

    public String[] splitByParagraph(String text) {

        return text.split("\n");
    }

    public String[] splitByWord(String text) {
        return text.split(" ");
    }
}
