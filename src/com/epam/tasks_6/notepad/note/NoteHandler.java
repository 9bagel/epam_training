package com.epam.tasks_6.notepad.note;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteHandler {
    private static NoteHandler instance = new NoteHandler();
    private String fileName = "notes.txt";
    private List<Note> notes = new ArrayList<>();

    public static NoteHandler getInstance() {
        instance.loadNotes();
        return instance;
    }

    private void loadNotes() {
        String topic;
        Date creationDate;
        String email;
        String msg;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] buffer;

            while ((line = reader.readLine()) != null) {
                buffer = line.split("\\|");

                topic = buffer[0];

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                creationDate = simpleDateFormat.parse(buffer[1]);

                email = buffer[2];
                msg = buffer[3];

                addNoteToList(topic, creationDate, email, msg);
            }

        } catch (IOException | ParseException e) {
            System.out.println("Что-то пошло не так при чтении из файла :(");
        }


    }

    private void saveNoteToFile(Note note) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(note.getTopic() + "|" + note.getCreationDate() + "|" + note.getEmail() + "|" + note.getMsg() + "\n");

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при записи в файл :(");
        }
    }

    private void addNoteToList(String topic, Date creationDate, String email, String msg) {
        notes.add(new Note(topic, creationDate, email, msg));
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void showNotes() {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    public void findNoteByTopic(String topic) {
        List<Note> notes = new ArrayList<>();
    }

    public void findNoteByCreationDate(Date creationDate) {
        List<Note> notes = new ArrayList<>();
    }

    public void findNoteByEmail(String email) {
        List<Note> notes = new ArrayList<>();
    }

    public void findNoteByMsg(String msg) {
        List<Note> notes = new ArrayList<>();
    }

    public void findNoteByTopicAndEmail(String topic, String email) {


    }

    public void findNoteByMsgAndCreationDate(String msg, Date date) {
        List<Note> notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        saveNoteToFile(note);
        notes.add(note);
    }

    public void removeNote() {

    }
}
