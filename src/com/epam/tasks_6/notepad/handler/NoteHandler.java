package com.epam.tasks_6.notepad.handler;

import com.epam.tasks_6.notepad.note.Note;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NoteHandler {
    private static NoteHandler instance = new NoteHandler();
    private String fileName = "notes.txt";
    private List<Note> notes = new ArrayList<>();

    public static NoteHandler getInstance() {
        instance.loadNotesFromFile();
        return instance;
    }

    private void loadNotesFromFile() {
        String topic;
        Date creationDate;
        String email;
        String msg;
        File file = new File(fileName);

        if (file.exists()) {

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                String[] buffer;

                while ((line = reader.readLine()) != null) {
                    buffer = line.split("\\|");

                    topic = buffer[0];

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    creationDate = simpleDateFormat.parse(buffer[1]);

                    email = buffer[2];
                    msg = buffer[3];

                    addNoteToList(new Note(topic, creationDate, email, msg));
                }

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public void saveNotesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (Note note : notes) {

                String date = simpleDateFormat.format(note.getCreationDate());

                writer.write(note.getTopic() + "|" + date + "|" + note.getEmail() + "|" + note.getMsg() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так при записи в файл :(");
        }
    }

    private void addNoteToList(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<Note> findNotesByTopic(String topic) {
        List<Note> matchedNotes = new ArrayList<>();

        for (Note note : notes) {

            if (note.getTopic().equals(topic)) {

                matchedNotes.add(note);
            }
        }

        sortNotes(matchedNotes);

        return matchedNotes;
    }

    public List<Note> findNotesByCreationDate(Date creationDate) {
        List<Note> matchedNotes = new ArrayList<>();

        for (Note note : notes) {
            if (note.getCreationDate().equals(creationDate)) {
                matchedNotes.add(note);
            }
        }
        sortNotes(matchedNotes);

        return matchedNotes;

    }

    public List<Note> findNotesByEmail(String email) {
        List<Note> matchedNotes = new ArrayList<>();

        for (Note note : notes) {
            if (note.getEmail().equals(email)) {
                matchedNotes.add(note);
            }
        }
        sortNotes(matchedNotes);

        return matchedNotes;

    }

    public List<Note> findNotesByMsg(String msg) {
        List<Note> matchedNotes = new ArrayList<>();

        for (Note note : notes) {
            if (note.getMsg().equals(msg)) {
                matchedNotes.add(note);
            }
        }
        sortNotes(matchedNotes);

        return matchedNotes;

    }

    public List<Note> findNotesByTopicAndEmail(String topic, String email) {
        List<Note> matchedNotes = new ArrayList<>();

        for (Note note : notes) {
            if (note.getTopic().equals(topic) && note.getEmail().equals(email)) {
                matchedNotes.add(note);
            }
        }
        sortNotes(matchedNotes);

        return matchedNotes;
    }

    public List<Note> findNoteByMsgAndCreationDate(String msg, Date date) {
        List<Note> matchedNotes = new ArrayList<>();

        for (Note note : notes) {
            if (note.getMsg().equals(msg) && note.getCreationDate().equals(date)) {
                matchedNotes.add(note);
            }
        }
        sortNotes(matchedNotes);

        return matchedNotes;

    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(String topic) {

        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getTopic().equals(topic)){
                notes.remove(i);
            }
        }
    }

    private void sortNotes(List<Note> sortingList) {
        sortingList.sort(Comparator.comparing(Note::getTopic));
    }
}
