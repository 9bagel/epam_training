package com.epam.tasks_6.library.auth;

import com.epam.tasks_6.library.user.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDataStore {
    private String fileName = "credentials.txt";

    private static UserDataStore instance = new UserDataStore();

    /**
     * Map of usernames to their password hashes.
     */
    private Map<String, String> userMap = new HashMap<>();

    public static UserDataStore getInstance() {
        instance.readUserData();
        return instance;
    }

    // This class is a singleton. Call getInstance() instead.
    public UserDataStore() {
    }

    //Читаем данные пользователей и заполняем данными userMap
    public void readUserData() {
        String userName;
        int passwordHash;
        boolean isAdmin;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] buffer;

            while ((line = reader.readLine()) != null) {
                buffer = line.split("\\|");

                userName = buffer[0];
                passwordHash = Integer.parseInt(buffer[1]);
                isAdmin = Boolean.parseBoolean(buffer[2]);

                userMap.put(userName, passwordHash + "|" + isAdmin);
            }

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при чтении из файла :(");
        }
    }

    //Записываем логин и хешированный пароль в файл
    public void writeCredentials(User user) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(user.getUserName() + "|" + user.getPasswordHash() + "|" + user.isAdmin() + "\n");

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при записи в файл :(");
        }
    }

    public boolean isUsernameTaken(String username) {
        return userMap.containsKey(username);
    }

    public User registerUser(String userName, String password, boolean isAdmin) {
        int passwordHash = getSimpleHash(password);
        User user = new User(userName, passwordHash, isAdmin);

        userMap.put(userName, passwordHash + "|" + isAdmin);
        writeCredentials(user);

        return user;
    }

    public User isLoginCorrect(String username, String password) {

        // username isn't registered
        if (!userMap.containsKey(username)) {
            return null;
        }

        int passwordHash = getSimpleHash(password);
        int storedPasswordHash = Integer.parseInt(userMap.get(username).split("\\|")[0]);
        boolean isAdmin = Boolean.parseBoolean(userMap.get(username).split("\\|")[1]);

        if (passwordHash == storedPasswordHash) {
            return new User(username, passwordHash, isAdmin);
        } else return null;
    }

    private int getSimpleHash(String password) {
        return password.hashCode();
    }
}
