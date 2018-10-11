/**
 * This class contains and maintains the list with arbitrary number of tasks
 * and provides all the necessary methods to operate on the tasks.
 * It does not initiate actions on its own behalf and all it's activities
 * are driven by the other classes.
*/
package com.todoly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class TaskList implements Serializable {

    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the task list.
     * @param newTask the task to add to the list
     */
    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Checks if index number of the task exists.
     * @param index task index number
     * @return true if the index number is valid, false otherwise
     */
    public boolean validIndex(int index) {
        boolean valid = index >= 0 && index < tasks.size();
        return valid;
    }

    /**
     * Removes a task from the taskList according to the index number.
     * @param index task index number
     */
    public void removeTask(int index) {
        if (validIndex(index)) {
            tasks.remove(index);
        }
    }

    /**
     * Counts all the tasks that are completed.
     * @return the number of completed tasks
     */
    public int numberDone() {
        int count = 0;
        for (Task task : tasks) {
            if (task.getComplete()) {
                count = count + 1;
            }
        }
        return count;
    }

    /**
     * Counts all the tasks that are not done yet.
     * @return the number of not completed tasks
     */
    public int numberNotDone() {
        int count = 0;
        for (Task task : tasks) {
            if (!task.getComplete()) {
                count = count + 1;
            }
        }
        return count;
    }

    /**
     * Returns a list of all the task that are not done.
     * @return a list of the not completed tasks
     */
    public ArrayList<Task> notDoneTasks() {
        ArrayList<Task> taskList = new ArrayList<>();
        for (Task task : tasks) {
            if(!task.getComplete()) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    /**
     * Filters the tasks by given project name
     * @param project name of the task project category
     * @return a list of tasks that match with the given project.
     */
    public ArrayList<Task> filterByProject(String project) {
        ArrayList<Task> projectList = new ArrayList<>();
        for (Task task : tasks) {
            if (project.equals(task.getProject())) {
                projectList.add(task);
            }
        }
        return projectList;
    }

    /**
     * Sorts the tasks by date.
     * @return a list of tasks sorted by date.
     */
    public ArrayList<Task> sortByDate() {
        ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
        Collections.sort(sortedTasks);
        return sortedTasks;
    }

}


