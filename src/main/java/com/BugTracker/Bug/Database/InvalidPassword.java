package com.BugTracker.Bug.Database;

public class InvalidPassword extends Exception {
    public InvalidPassword(String message) {
        super(message);
    }
}
