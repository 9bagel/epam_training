package com.epam.tasks_6.archive.server.auth;

import com.epam.tasks_6.archive.server.console.Console;
import com.epam.tasks_6.archive.server.user.UserHandler;
import com.epam.tasks_6.archive.server.user.User;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Authenticator {
    private UserHandler userHandler = UserHandler.getInstance();
    private User user;
    private Console console = Console.getInstance();

    public Authenticator() throws IOException, XMLStreamException {
    }

    public User logIn() throws IOException {
        while (true) {
            String userName = console.sendCommandWithResponse("Enter your name");
            String password = console.sendCommandWithResponse("Enter your password");

            user = userHandler.isLoginCorrect(userName, password);

            if (user != null) {
                console.sendCommand("U just logged in, congratz!");
                return user;
            } else {
                console.sendCommand("Username or password is incorrect try again");
            }
        }
    }

    public void endJob() throws FileNotFoundException, XMLStreamException {
        userHandler.writeUserData();
    }

    public User signUp() throws IOException, XMLStreamException {
        while (true) {
            String userName = console.sendCommandWithResponse("Enter username");
            if (userHandler.isUsernameTaken(userName)) {
                console.sendCommand("This name is taken, try different one");
            } else {
                String password = console.sendCommandWithResponse("Enter password");
                boolean isAdmin = Boolean.parseBoolean(console.sendCommandWithResponse("Is admin? (true|false)"));

                return userHandler.registerUser(userName, password, isAdmin);
            }


        }
    }

}
