package com.epam.programming_with_classes.agregation_and_composition.task_1;
/*
 Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
консоль текст, заголовок текста.
 */
public class Main {
    public static void main(String[] args) {
        Text text = new Text("Text", "title");

        text.addSentence(new Sentence("New sentence"));

    }
}
