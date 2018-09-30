package com.todoly;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public boolean validIndex(int index) {
        boolean valid = index >= 0 && index < tasks.size();
        return valid;
    }

    public void removeTask(int index) {
        if (validIndex(index)) {
            tasks.remove(index);
        }
    }

    //Returns the number of completed tasks.
    public int numberDone() {
        int count = 0;
        for (Task task : tasks) {
            if (task.getComplete()) {
                count = count + 1;
            }
        }
        return count;
    }

    //Returns the number of not completed tasks.
    public int numberNotDone() {
        int count = 0;
        for (Task task : tasks) {
            if (!task.getComplete()) {
                count = count + 1;
            }
        }
        return count;
    }

    //Returns all the task that are not done.
    public ArrayList<Task> notDoneTasks() {
        ArrayList<Task> taskList = new ArrayList<>();
        for (Task task : tasks) {
            if(!task.getComplete()) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    //Returns the list of tasks that match with the given project.
    public ArrayList<Task> filterByProject(String project) {
        ArrayList<Task> projectList = new ArrayList<>();
        for (Task task : tasks) {
            if (project.equals(task.getProject())) {
                projectList.add(task);
            }
        }
        return projectList;
    }
}


