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

        public void listTasks() {
            for(Task task : tasks) {
                System.out.println(task);
            }
        }
}
