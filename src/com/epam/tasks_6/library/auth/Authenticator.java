package com.epam.tasks_6.library.auth;

import com.epam.tasks_6.library.user.User;

import java.util.Scanner;

public class Authenticator {
    private Scanner scanner = new Scanner(System.in);
    private UserDataStore userDataStore = UserDataStore.getInstance();
    private User user;

    public User logIn() {
        String userName;
        String password;

        while (true) {
            System.out.println("Введите Логин");
            userName = scanner.nextLine();

            System.out.println("Введите пароль");
            password = scanner.nextLine();

            user = userDataStore.isLoginCorrect(userName, password);

            if (user != null) {
                System.out.println("Вы вошли в систему как " + user.getUserName());
                return user;
            } else {
                System.out.println("Неверно введён логин или пароль");
            }
        }
    }

    public User signUp() {

        String userName;
        String password;
        boolean isAdmin;

        System.out.println("Введите Логин");
        userName = scanner.nextLine();

        while (userDataStore.isUsernameTaken(userName)) {
            System.out.println("Логин уже занят, попробуйте другой");
            userName = scanner.nextLine();
        }

        System.out.println("Введите пароль");
        password = scanner.nextLine();

        System.out.println("Пользователь админ? (true, false)");
        while (!scanner.hasNextBoolean()) {
            System.out.println("true - если пользователь админ и false - если нет");
            scanner.next();
        }

        isAdmin = scanner.nextBoolean();

        return userDataStore.registerUser(userName, password, isAdmin);
    }

}
