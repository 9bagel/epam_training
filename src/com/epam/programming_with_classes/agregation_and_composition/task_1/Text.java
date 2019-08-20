package com.epam.programming_with_classes.agregation_and_composition.task_1;

/*
 Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
консоль текст, заголовок текста.
 */
class Text {

    private StringBuilder text;
    private String title;

    Text(String text) {
        this.text = new StringBuilder(text);
        this.title = null;
    }

    Text(StringBuilder text, String title) {
        this.text = text;
        this.title = title;
    }

    Text(String text, String title) {
        this.text = new StringBuilder(text);
        this.title = title;
    }

     void addSentence(Sentence sentence) {
        text.append(sentence.toString());
    }

     void addWord(String word) {
        text.append(word);
    }

     void printText() {
        System.out.println(text.toString());
    }

     void printTitle() {
        System.out.println(title);
    }

}
