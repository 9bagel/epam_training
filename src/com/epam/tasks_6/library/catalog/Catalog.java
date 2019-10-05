package com.epam.tasks_6.library.catalog;

import com.epam.tasks_6.library.book.Book;
import com.epam.tasks_6.library.book.BookType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog {
    private static Catalog instance = new Catalog();
    private String fileName = "books.txt";

    private List<Book> books = new ArrayList<>();

    public static Catalog getInstance() {
        instance.readCatalogFromFile();
        return instance;
    }

    private Catalog() {

    }

    public void addBook(Book book) {
        books.add(book);
        writeBookToFile(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void watchCatalog() {

        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d - %s\n", i, books.get(i).getTitle());
        }

        int choice;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            do {
                System.out.println("Введите номер книги, которую вы хотите открыть или exit, чтобы выйти из каталога");
                while (!scanner.hasNextInt()) {
                    if (scanner.nextLine().equals("exit")) {
                        return;
                    }
                }

                choice = scanner.nextInt();

            } while (choice < 0 || choice > books.size() - 1);

            System.out.println(books.get(choice));
        }
    }

    public Book findBook(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }

    public void readCatalogFromFile() {
        String title;
        String description;
        String authors;
        BookType bookType;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] buffer;

            while ((line = reader.readLine()) != null) {
                buffer = line.split("\\|");

                title = buffer[0];
                description = buffer[1];
                authors = buffer[2];
                bookType = BookType.valueOf(buffer[3]);

                books.add(new Book(bookType, title, authors, description));
            }

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при чтении из файла :(");
        }
    }

    public void writeBookToFile(Book book) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(book.getTitle() + "|" + book.getDescription() + "|" + book.getAuthors() + "|" + book.getBookType() + "\n");

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при записи в файл :(");
        }
    }
}
