package com.todoly;

public class Task {

    private String title;
    private String dueDate;
    private boolean complete;
    private String project;

    public Task(String title, String dueDate, String project) {
        this.title = title;
        this.complete = false;
        this.dueDate = dueDate;
        this.project = project;
    }

    public Task(String title) {
        this(title, null, null);
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String toString() {
        String result = "    ~~~~~~~~~~~\n";

        result += "Task:\t\t" + title + "\nStatus:\t\t";

        if (complete) {
            result += "done";
        }
        else {
            result += "not done";
        }
        result += "\nDue Date:\t" + dueDate;
        result += "\nProject:\t" + project + "\n";

        return result;

    }
}
