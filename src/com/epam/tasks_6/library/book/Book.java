package com.epam.tasks_6.library.book;

import java.util.Scanner;

public class Book {
    private BookType bookType;
    private String title;
    private String authors;
    private String description;

    public Book(BookType bookType, String title, String authors, String description) {
        this.bookType = bookType;
        this.title = title;
        this.authors = authors;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Тип книги =" + bookType +
                "\n Название ='" + title + '\'' +
                "\n Авторы ='" + authors + '\'' +
                "\n Описание ='" + description;
    }

    public static Book createBookFromConsole() {
        String title;
        BookType bookType;
        String authors;
        String description;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название книги");
        title = scanner.nextLine();

        System.out.println("Введите имена авторов");
        authors = scanner.nextLine();

        //Здесь без проверки
        System.out.println("Введите тип книги EBOOK или PAPER_BOOK");
        bookType = BookType.valueOf(scanner.nextLine());

        System.out.println("Введите описание");
        description = scanner.nextLine();

        return new Book(bookType, title, authors, description);
    }
}
