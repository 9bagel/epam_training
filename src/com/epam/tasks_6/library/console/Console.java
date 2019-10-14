package com.epam.tasks_6.library.console;

import com.epam.tasks_6.library.book.Book;
import com.epam.tasks_6.library.catalog.Catalog;
import com.epam.tasks_6.library.mail.EmailHandler;
import com.epam.tasks_6.library.user.User;

import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private Catalog catalog = Catalog.getInstance();
    private EmailHandler emailHandler = EmailHandler.getInstance();

    public void getConsole(User user) {
        if (user.isAdmin()) {
            getAdminConsole(user);
        } else {
            getUserConsole(user);
        }
    }

    private void getUserConsole(User user) {

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
                    emailHandler.sendEmail(Book.createBookFromConsole(), user.getUserName());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ошибка");
            }
        }
    }

    private void getAdminConsole(User user) {
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
