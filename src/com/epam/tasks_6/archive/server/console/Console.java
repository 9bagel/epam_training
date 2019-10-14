package com.epam.tasks_6.archive.server.console;

import com.epam.tasks_6.archive.server.auth.Authenticator;
import com.epam.tasks_6.archive.server.student.Student;
import com.epam.tasks_6.archive.server.student.StudentHandler;
import com.epam.tasks_6.archive.server.user.User;

import javax.xml.stream.XMLStreamException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Console {

    private BufferedReader reader;
    private BufferedWriter writer;

    private static Console instance = new Console();

    public static Console getInstance() {
        return instance;
    }

    private StudentHandler studentHandler = StudentHandler.getInstance();

    private Console() {
    }

    public void startConsole(BufferedReader reader, BufferedWriter writer) throws IOException, XMLStreamException {
        instance.reader = reader;
        instance.writer = writer;

        User user;
        Authenticator authenticator = new Authenticator();

        while (true) {
            String response = sendCommandWithResponse("Type Log in or Sign up");

            switch (response.toUpperCase()) {
                case "LOG IN":
                    user = authenticator.logIn();
                    break;
                case "SIGN UP":
                    user = authenticator.signUp();
                    break;
                default:
                    sendCommand("Blabla");
                    return;
            }
            if (user.isAdmin()) {
                adminConsole();
            } else userConsole();
        }

    }

    private void userConsole() throws IOException {
        while (true) {
            String response = sendCommandWithResponse("1 - show all students data, 0 - to quit");

            switch (response) {
                case "0":
                    return;
                case "1":
                    studentHandler.showAllStudents();
                    break;
                default:
                    sendCommand("Choose correct option");
            }
        }
    }

    private void adminConsole() throws IOException, XMLStreamException {
        String response = sendCommandWithResponse("1 - show all students data 2 - find student 3 - add new student 4 - edit student 0 - to exit");

        while (true) {
            String name;
            Student student;
            switch (response) {
                case "0":
                    return;
                case "1":
                    studentHandler.showAllStudents();
                    break;
                case "2":
                    name = sendCommandWithResponse("Type student name");
                    student = studentHandler.findStudent(name);

                    if (student != null) {
                        sendCommand("Student found:");
                        sendCommand(student.toString());
                    } else sendCommand("Student  didn't found");
                    break;
                case "3":
                    name = sendCommandWithResponse("Type student name");
                    int averageMark = Integer.parseInt(sendCommandWithResponse("Type average mark"));

                    studentHandler.addNewStudent(new Student(name, averageMark));
                    break;
                case "4":
                    studentHandler.editStudent();
                    break;
                default:
                    response = sendCommandWithResponse("Choose correct option");
            }
        }
    }

    public String sendCommandWithResponse(String command) throws IOException {
        writer.write(command);
        writer.newLine();
        writer.flush();

        return reader.readLine();
    }

    public void sendCommand(String command) throws IOException {
        writer.write(command);
        writer.newLine();
    }

}
