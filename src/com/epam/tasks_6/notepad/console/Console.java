package com.epam.tasks_6.notepad.console;

import com.epam.tasks_6.notepad.note.Note;
import com.epam.tasks_6.notepad.handler.NoteHandler;
import com.epam.tasks_6.notepad.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {
    private static Console instance = new Console();
    private Scanner scanner = new Scanner(System.in);
    private NoteHandler noteHandler = NoteHandler.getInstance();
    private View view = new View();

    /**
     * Pattern that simply checks if @ is represent  (can use more powerful patterns from the internet if needed)
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");

    public static Console getInstance() {
        return instance;
    }

    private void runConsoleSearch() {

        int choice;
        do {
            System.out.println("**********Search***********");
            System.out.println("1 - find notes by topic\n" +
                    "2 - find notes by date of creation\n" +
                    "3 - find notes by email\n" +
                    "4 - find notes by message\n" +
                    "5 - find notes by topic and email\n" +
                    "6 - find note by message and date of creation\n" +
                    "exit - to quit from notepad");
            while (!scanner.hasNextInt()) {

                if (scanner.next().equals("exit")) {
                    noteHandler.saveNotesToFile();
                    System.exit(0);
                }

                System.out.println("Choose correct option");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

        } while (choice < 1 || choice > 6);

        switch (choice) {
            case 1://by topic
                view.displayNotes(noteHandler.findNotesByTopic(topicConsole()));
                break;
            case 2://by date of creation
                view.displayNotes(noteHandler.findNotesByCreationDate(dateOfCreationConsole()));
                break;
            case 3://by email
                view.displayNotes(noteHandler.findNotesByEmail(emailConsole()));
                break;
            case 4://by message
                view.displayNotes(noteHandler.findNotesByMsg(msgConsole()));
                break;
            case 5://by topic and email
                view.displayNotes(noteHandler.findNotesByTopicAndEmail(topicConsole(), emailConsole()));
                break;
            case 6://by message and date of creation
                view.displayNotes(noteHandler.findNoteByMsgAndCreationDate(msgConsole(), dateOfCreationConsole()));
                break;
            default:
                break;
        }

    }

    public void runConsoleMenu() {
        while (true) {
            int choice;
            do {
                System.out.println("**********NotePad***********");
                System.out.println("1 - Show all notes\n" +
                        "2 - Add new note\n" +
                        "3 - Remove note\n" +
                        "4 - Find note\n" +
                        "exit - to quit from notepad");
                while (!scanner.hasNextInt()) {

                    if (scanner.next().equals("exit")) {
                        noteHandler.saveNotesToFile();
                        System.exit(0);
                    }

                    System.out.println("Choose correct option");
                }

                choice = scanner.nextInt();
                scanner.nextLine();

            } while (choice < 1 || choice > 4);

            switch (choice) {
                case 1://show all notes
                    view.displayNotes(noteHandler.getNotes());
                    break;
                case 2://add new note
                    noteHandler.addNote(new Note(topicConsole(), dateOfCreationConsole(), emailConsole(), msgConsole()));
                    break;
                case 3://remove note
                    noteHandler.removeNote(topicConsole());
                    break;
                case 4://find note
                    runConsoleSearch();
                    break;
                default:
                    break;
            }
        }

    }

    private String topicConsole() {
        System.out.println("Enter topic:");
        return scanner.nextLine();
    }

    private Date dateOfCreationConsole() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;

        System.out.println("Enter date of creation like dd/MM/yyyy:");

        while (true) {

            try {
                date = simpleDateFormat.parse(scanner.nextLine());

                return date;
            } catch (ParseException e) {
                System.out.println("Date must be like dd/MM/yyyy  try again");
            }
        }
    }

    private String msgConsole() {
        System.out.println("Enter message:");
        return scanner.nextLine();
    }

    private String emailConsole() {

        while (true) {
            System.out.println("Enter email:");
            String email = scanner.nextLine();

            if (EMAIL_PATTERN.matcher(email).find()) {
                return email;
            }

            System.out.println("Incorrect email");
        }

    }

}
