package com.epam.strings_and_basics_of_text_processing.regex.task1;

import java.util.Scanner;

class StartProgram {

    private String text;

    public StartProgram(String text) {
        this.text = text;
        chooseAnOption();
    }

    private void chooseAnOption() {
        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Что будем делать с текстом?");
            System.out.println("1 - отсортировать абзацы по количеству предложений");
            System.out.println("2 - в каждом предложении отсортировать слова по длине");
            System.out.println("3 - отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту");

            while (!scanner.hasNextInt()) {
                System.out.println("Это должно быть число!");
                scanner.next();
            }
            option = scanner.nextInt();

        } while (option < 1 || option > 3);


        Sort sort = new Sort();

        switch (option) {
            case 1:
                sort.bySentenceCount(text);
                break;
            case 2:
                sort.byWordLength(text);
                break;
            case 3:
                char symbol;
                System.out.println("Введите символ, по которому будем сортировать");

                while (!scanner.hasNext()) {
                    scanner.next();
                }

                symbol = scanner.next().charAt(0);
                sort.byLexemeCount(text, symbol);

                break;
        }
    }
}
