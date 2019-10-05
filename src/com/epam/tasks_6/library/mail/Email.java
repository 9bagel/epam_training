package com.epam.tasks_6.library.mail;

import com.epam.tasks_6.library.book.Book;

public class Email {
    private String userName;
    private Book book;

    public String getUserName() {
        return userName;
    }

    public Email(String userName, Book book) {
        this.userName = userName;
        this.book = book;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Email{" +
                "userName='" + userName + '\'' +
                ", book=" + book +
                '}';
    }
}
