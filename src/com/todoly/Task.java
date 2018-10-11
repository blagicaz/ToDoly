/**
 * This class stores all the information about a task.
 * Details are shown by task title, due date, completion, and project name.
 */

package com.todoly;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Comparable<Task>, Serializable {

    private String title;
    private Date dueDate;
    private boolean complete;
    private String project;

    public Task(String title, Date dueDate, String project) {
        this.title = title;
        this.complete = false;
        this.dueDate = dueDate;
        this.project = project;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    /**
     * String representation of the task.
     * @return a task in String format
     */
    public String toString() {
        String result = "\t~~~~~~~~~~~\n";

        result += "Task:\t\t" + title + "\nStatus:\t\t";

        if (complete) {
            result += "done";
        }
        else {
            result += "not done";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        result += "\nDue Date:\t" + sdf.format(dueDate);
        result += "\nProject:\t" + project + "\n";

        return result;
    }

    /**
     * Implements comparison logic based on the dueDate field.
     * @param task the task to compare this task to.
     * @return an integer result of comparing values.
     */
    @Override
    public int compareTo(Task task) {
        int result = this.dueDate.compareTo(task.dueDate);
        return result;
    }
}
