package com.epam.tasks_6.library.user;

public class User {
    private String userName;
    private int passwordHash;
    private boolean isAdmin;

    public User(String userName, int passwordHash, boolean isAdmin) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}


