package com.BugTracker.Bug.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;

@Component
@SessionScope
public class UserSession {
    private int userId;
    HashMap<Integer, Integer> myProjects = new HashMap<>();
    HashMap<Integer, Integer> myBugs = new HashMap<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public HashMap <Integer, Integer> getMyProjects() {
        return myProjects;
    }

    public void setMyProjects(HashMap <Integer, Integer> myProjects) {
        this.myProjects = myProjects;
    }

    public HashMap<Integer, Integer> getMyBugs() {
        return myBugs;
    }

    public void setMyBugs(HashMap<Integer, Integer> myBugs) {
        this.myBugs = myBugs;
    }

    public void addNewProject (Integer id) {
        if (myProjects.get(id) != null) {
            int currentQuantity = myProjects.get(id);
            int newQuantity = currentQuantity +1;
            myProjects.put(id, newQuantity);
        } else {
            myProjects.put(id, 1);
        }
    }

    public void addNewBug (Integer id) {
        if (myBugs.get(id) != null) {
            int currentQuantity = myBugs.get(id);
            int newQuantity = currentQuantity +1;
            myBugs.put(id, newQuantity);
        } else {
            myBugs.put(id, 1);
        }
    }
}
