package com.BugTracker.Bug.Database;

public class User {
    private int idLogin;
    private String email;
    private String password;

    public int getId() {
        return idLogin;
    }

    public void setId(int id) {
        this.idLogin = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
