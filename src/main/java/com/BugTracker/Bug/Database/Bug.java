package com.BugTracker.Bug.Database;

public class Bug {

    private int idBugs;
    private String BugName;
    private int BugNumber;
    private String BugDescription;
    private String url;

    public int getId() {
        return idBugs;
    }

    public void setId(int id) {
        this.idBugs = id;
    }

    public String getName() {
        return BugName;
    }

    public void setName(String name) {
        this.BugName = name;
    }

    public int getNumber() {
        return BugNumber;
    }

    public void setNumber(int number) {
        this.BugNumber = number;
    }

    public String getDescription() {
        return BugDescription;
    }

    public void setDescription(String description) {
        this.BugDescription = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
