package com.todoly;

public class Task {

    private String title;
    private String dueDate;
    private boolean complete;
    private String project;

    public Task(String title) {
        this.title = title;
        this.complete = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String toString() {

        String result = title + ": ";

        if (complete) {
            result += "done";
        }
        else {
            result += "not done";
        }

        return result;
    }
}
