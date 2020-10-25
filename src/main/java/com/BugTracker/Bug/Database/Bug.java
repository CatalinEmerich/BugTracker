package com.BugTracker.Bug.Database;

public class Bug {

    private int idBug;
    private String bugName;
    private int bugNumber;
    private String bugDescription;
    private String url;

    public int getIdBug() {
        return idBug;
    }

    public void setIdBug(int idBug) {
        this.idBug = idBug;
    }

    public String getBugName() {
        return bugName;
    }

    public void setBugName(String bugName) {
        this.bugName = bugName;
    }

    public int getBugNumber() {
        return bugNumber;
    }

    public void setBugNumber(int bugNumber) {
        this.bugNumber = bugNumber;
    }

    public String getBugDescription() {
        return bugDescription;
    }

    public void setBugDescription(String bugDescription) {
        this.bugDescription = bugDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
