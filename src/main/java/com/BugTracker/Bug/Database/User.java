package com.BugTracker.Bug.Database;

public class User {
    private int idLogin;
    private String Email;
    private String Password;

    public int getId() {
        return idLogin;
    }

    public void setId(int id) {
        this.idLogin = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
