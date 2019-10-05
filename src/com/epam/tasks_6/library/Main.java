package com.epam.tasks_6.library;

import com.epam.tasks_6.library.auth.Authenticator;
import com.epam.tasks_6.library.role.User;

import java.util.Scanner;

public class Main {

    private static User user;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("1 - Log In"
                    + "\n2 - Sign Up");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }

            choice = scanner.nextInt();

        } while (choice != 1 && choice != 2);

        Authenticator authenticator = new Authenticator();
        switch (choice) {
            case 1:
                user = authenticator.logIn();
                user.getConsole();
                break;
            case 2:
                user = authenticator.signUp();
                user.getConsole();
                break;
            default:
                System.out.println("Что-то пошло не так");
                System.exit(0);
                break;
        }

    }
}
