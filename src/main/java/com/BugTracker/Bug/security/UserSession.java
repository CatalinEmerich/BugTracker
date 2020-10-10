package com.BugTracker.Bug.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
//asa separam fiecare sesiune:
@SessionScope
public class UserSession {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
