package com.epam.tasks_6.library.role;

import com.epam.tasks_6.library.book.Book;
import com.epam.tasks_6.library.book.BookType;
import com.epam.tasks_6.library.catalog.Catalog;
import com.epam.tasks_6.library.mail.EmailHandler;

import java.util.Scanner;

public class User {
    private String userName;
    private int passwordHash;
    private boolean isAdmin;
    private Scanner scanner = new Scanner(System.in);
    private Catalog catalog = Catalog.getInstance();
    private EmailHandler emailHandler = EmailHandler.getInstance();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public User(String userName, int passwordHash, boolean isAdmin) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.isAdmin = isAdmin;
    }

    public void getConsole() {
        if (isAdmin) {
            getAdminConsole();
        } else {
            getUserConsole();
        }
    }

    public void getUserConsole() {

        int choice;
        while (true) {
            do {
                System.out.println("1 - Просмотреть книги в каталоге\n" +
                        "2 - Поиск книги в каталоге\n" +
                        "3 - Предложить добавить книгу\n" +
                        "0 - Выход из библиотеки\n");
                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                }

                choice = scanner.nextInt();

            } while (choice < 0 || choice > 3);

            switch (choice) {
                case 1:
                    catalog.watchCatalog();
                    break;
                case 2:
                    System.out.println("Введите название книги, которую вы ищите");
                    Scanner scanner2 = new Scanner(System.in);
                    String title = scanner2.nextLine();

                    Book book = catalog.findBook(title);

                    if (book == null) {
                        System.out.println("Такой книги нет в каталоге");
                    } else {
                        System.out.println(book.toString());
                    }
                    break;
                case 3:
                    emailHandler.sendEmail(Book.createBookFromConsole(), userName);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ошибка");
            }
        }
    }

    public void getAdminConsole() {

        int choice;
        while (true) {
            do {
                System.out.println("1 - Просмотреть книги в каталоге\n" +
                        "2 - Добавить книгу в каталог\n" +
                        "3 - Проверить почту\n" +
                        "4 - Очистить почту\n" +
                        "0 - Выйти\n");

                while (!scanner.hasNextInt()) {
                    scanner.next();
                }

                choice = scanner.nextInt();

            } while (choice < 0 || choice > 4);

            switch (choice) {
                case 1:
                    catalog.watchCatalog();
                    break;
                case 2:
                    catalog.addBook(Book.createBookFromConsole());
                    System.out.println("Книга была добавлена");
                    break;
                case 3:
                    emailHandler.getEmails();
                    break;
                case 4:
                    emailHandler.clearEmails();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ошибка");
            }
        }
    }
}
