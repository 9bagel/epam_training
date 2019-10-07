package com.epam.tasks_6.notepad.view;

import com.epam.tasks_6.notepad.note.Note;

import java.util.List;

public class View {
    public void displayNotes(List<Note> notes) {

        if (notes.isEmpty()) {
            System.out.println("There are no notes to display");
        } else {
            for (Note note : notes) {
                System.out.println(note);
            }
        }
    }
}
