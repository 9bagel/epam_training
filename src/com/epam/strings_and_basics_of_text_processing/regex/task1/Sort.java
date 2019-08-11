package com.epam.strings_and_basics_of_text_processing.regex.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Sort {
    private PrintResult printResult = new PrintResult();
    private Spliter spliter = new Spliter();

    //отсортировать абзацы по количеству предложений
    void bySentenceCount(String text) {
        String[] paragraphs = spliter.splitByParagraph(text);

        Arrays.sort(paragraphs, (paragraph1, paragraph2) ->
                paragraph1.split("[!?.:]+").length >= paragraph2.split("[!?.:]+").length ? 1 : -1);

        printResult.print(paragraphs);
    }

    //в каждом предложении отсортировать слова по длине
    void byWordLength(String text) {
        String[] paragraphs = spliter.splitByParagraph(text);

        for (int i = 0; i < paragraphs.length; i++) {
            String[] words = spliter.splitByWord(paragraphs[i]);

            Arrays.sort(words, Comparator.comparingInt(String::length));

            String result = String.join(" ", words);
            printResult.print(result);
        }
    }

    //отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
    public void byLexemeCount(String text, char symbol) {
        String[] paragraphs = spliter.splitByParagraph(text);

        for (String paragraph : paragraphs) {
            String[] words = spliter.splitByWord(paragraph);

            //Спасибо стримам, что не пришлось мне писать кучу loop'ов
            String result = Arrays.stream(words)
                    //Сравниваем слова по количеству вхождений символа
                    .sorted(Comparator.comparingLong((String word) -> word.chars()
                            .filter(ch -> ch == symbol)
                            .count())
                            //А если число вхождений одинаковое, то тогда по алфавиту сравниваем
                            .thenComparing(String.CASE_INSENSITIVE_ORDER)).collect(Collectors.joining(" "));

            printResult.print(result);
        }
    }
}
