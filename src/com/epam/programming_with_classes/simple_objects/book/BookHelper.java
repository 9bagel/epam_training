package com.epam.programming_with_classes.simple_objects.book;

import java.util.stream.Stream;

/*
 Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
 */
public class BookHelper {

    Book[] books = createBooks();

    //список книг заданного автора;
    void printAuthorBooks(String author) {
        Stream.of(books).filter(book -> book.getAuthors().equals(author)).forEach(System.out::println);
    }

    //список книг, выпущенных заданным издательством;
    void printPublisherBooks(String publisher) {
        Stream.of(books).filter(book -> book.getPublisher().equals(publisher)).forEach(System.out::println);
    }

    //список книг, выпущенных после заданного года.
    void printBooksAfterYear(int year) {
        Stream.of(books).filter(book -> book.getYear() >= year).forEach(System.out::println);
    }

    Book[] createBooks() {

        Book[] books = new Book[5];

        books[0] = new Book("Thinking in Java", "Bruce Eckel", "Prentice Hall", 2006, 1079, 79.5, "твёрдая", 1);
        books[1] = new Book("I am an author", "S. Dorozhko", "DorPub", 2015, 100, 5, "твёрдая", 2);
        books[2] = new Book("Head First Java", "Bert Bates, Kathy Sierra", " O'Reilly Media, Inc.", 2005, 690, 30.7, "твёрдая", 3);
        books[3] = new Book("i am a programmer", "Ivanov P. Dorozhko S.", "DorPub", 2019, 234, 10, "твёрдая", 4);
        books[4] = new Book("My life", "Dorozhko S.", "DorPub", 2019, 334, 15, "твёрдая", 5);


        return books;
    }
}
