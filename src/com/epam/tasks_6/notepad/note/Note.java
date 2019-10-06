package com.epam.tasks_6.notepad.note;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 9bagel
 */
public class Note {
    /**
     * Contains the topic of the note
     */
    private String topic;
    /**
     * Contains date of creation
     */
    private Date creationDate;
    /**
     * Contains email
     */
    private String email;
    /**
     * Contains message
     */
    private String msg;

    /**
     * Creates new Note
     *
     * @param topic
     * @param creationDate
     * @param email
     * @param msg
     */
    public Note(String topic, Date creationDate, String email, String msg) {
        this.topic = topic;
        this.creationDate = creationDate;
        this.email = email;
        this.msg = msg;
    }

    /**
     * Returns topic of the note
     *
     * @return
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets topic of the note
     *
     * @param topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Returns date of creation
     *
     * @return
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets date of creation
     *
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns an email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email for note
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns message of the note
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets message for the note
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Represents note as a string
     * @return
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return topic + "|" + email + "|" + msg + "|" + dateFormat.format(creationDate);
    }
}
