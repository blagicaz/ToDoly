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
}
