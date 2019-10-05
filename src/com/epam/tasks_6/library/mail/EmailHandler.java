package com.epam.tasks_6.library.mail;

import com.epam.tasks_6.library.book.Book;
import com.epam.tasks_6.library.book.BookType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmailHandler {

    private static EmailHandler instance = new EmailHandler();
    private String fileName = "emails.txt";
    private List<Email> emailList = new ArrayList<>();

    public static EmailHandler getInstance() {
        instance.readEmailsFromFile();
        return instance;
    }

    private EmailHandler() {
    }

    public void sendEmail(Book book, String userName) {
        emailList.add(new Email(userName, book));
        writeEmailToFile(book, userName);
        System.out.println("Email был отпрален админу");
    }

    public void getEmails() {
        for (Email email : emailList) {
            System.out.println("Логин отправителя " + email.getUserName() + "\n" + email.getBook());
        }
    }

    public void clearEmails() {
        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        emailList = null;
    }

    public void readEmailsFromFile() {
        String userName;
        String title;
        String description;
        String authors;
        BookType bookType;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] buffer;

            while ((line = reader.readLine()) != null) {
                buffer = line.split("\\|");

                userName = buffer[0];
                title = buffer[1];
                description = buffer[2];
                authors = buffer[3];
                bookType = BookType.valueOf(buffer[4]);

                Email email = new Email(userName, new Book(bookType, title, authors, description));
                emailList.add(email);
            }

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при чтении из файла :(");
        }
    }

    public void writeEmailToFile(Book book, String userName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(userName + "|" + book.getTitle() + "|" + book.getDescription() + "|" + book.getAuthors() + "|" + book.getBookType() + "\n");

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при записи в файл :(");
        }
    }
}
