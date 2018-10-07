package com.todoly;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ToDolyApp {

    private TaskList taskList;
    private CLI cli;
    private static final String FILE_NAME = "ToDoly.dat";

    public ToDolyApp() {
        taskList = new TaskList();
        cli = new CLI();
    }

    public void printWelcomeMessage() {
        int notDone = taskList.numberNotDone();
        int done = taskList.numberDone();
        System.out.println(">> Welcome to ToDoly");
        System.out.println(">> You have "+ notDone + " tasks todo and " + done + " tasks are done!");
    }

    public void printTasks(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }

    // Prints all the tasks stored in the taskList with their index number.
    public void printAllTasks() {
        int counter = 0;
        for (Task task : taskList.getTasks()) {
            System.out.println(counter);
            System.out.println(task.toString());
            counter ++;
        }
    }

    public void createTask() {
        System.out.print("Enter task title: ");
        String title = cli.readUserInput();
        System.out.print("Enter task project: ");
        String project = cli.readUserInput();
        System.out.print("Enter due date (format: YYYY-MM-DD): ");
        String dueDate = cli.readUserInput();
        Task t = new Task(title, dueDate, project);
        taskList.addTask(t);
    }

    // Prints all the tasks and user chooses a task to edit.
    // Prints a edit submenu for the task selected.
    public void editTask() {
        printAllTasks();
        boolean valid = false;
        while (valid == false) {
            System.out.print("Enter the number of the task you want to edit => ");
            String indexStr = cli.readUserInput();
            try {
                int index = Integer.parseInt(indexStr);

                valid = taskList.validIndex(index);
                if (valid == true) {
                    Task task = taskList.getTasks().get(index);
                    boolean success = false;
                    while (success == false) {
                        cli.printEditTaskMenu();
                        String userInput = cli.readUserInput();
                        success = processEditTaskMenuInput(task, index, userInput);
                        if (success == true) {
                            System.out.println("Task has been successfully edited");
                        }
                    }
                }
                else {
                    System.out.println("Invalid index. Can't edit task");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    //Prints the list task submenu and processing the user input.
    public void listTasks() {
        boolean succsess = false;
        while (succsess == false) {
            cli.printListTasksMenu();
            String userInput = cli.readUserInput();
            succsess = processListTasksMenuInput(userInput);
        }
    }

    // Processing the user input.
    // Return true if the user choose to quit, false for all the other options.
    public boolean processMainMenuInput(String userInput) {
        boolean quit = false;

        if (cli.validMainMenuInput(userInput)) {
            if (userInput.equals("1")) {
                listTasks();
            }
            else if (userInput.equals("2")) {
                createTask();
            }
            else if (userInput.equals("3")) {
                editTask();
            }
            else if (userInput.equals("4")) {
                System.out.println("Exiting app");
                quit = true;
            }
        }
        else {
            System.out.println("Unknown input");
        }

        return quit;
    }

    //Processing the user input for the editTask submenu.
    public boolean processEditTaskMenuInput(Task task, int taskIndex, String userInput) {
        if (cli.validEditTaskMenuInput(userInput)) {
            if (userInput.equals("1")) {
                task.setComplete(true);
            }
            else if (userInput.equals("2")) {
                task.setComplete(false);
            }
            else if (userInput.equals("3")) {
                System.out.print("Enter new task title: ");
                String newTitle = cli.readUserInput();
                task.setTitle(newTitle);
            }
            else if (userInput.equals("4")) {
                System.out.print("Enter new due date (format: YYYY-MM-DD): ");
                String newDate = cli.readUserInput();
                task.setDueDate(newDate);
            }
            else if (userInput.equals("5")) {
                System.out.println("Enter new task project: ");
                String newProject = cli.readUserInput();
                task.setProject(newProject);
            }
            else if (userInput.equals("6")) {
                System.out.println("Remove task");
                taskList.removeTask(taskIndex);
            }
            return true;
        }
        else {
            System.out.println("Unknown input \n");
            return false;
        }
    }

    //Processing the user input for the listTask submenu.
    public boolean processListTasksMenuInput(String userInput) {

        if (cli.validListTasksMenuInput(userInput)) {
            if (userInput.equals("1")) {
                printTasks(taskList.notDoneTasks());
            }
            else if (userInput.equals("2")) {
                printTasks(taskList.sortByDate());
            }
            else if (userInput.equals("3")) {
                System.out.println("Enter project name: ");
                String project = cli.readUserInput();
                printTasks(taskList.filterByProject(project));
            }
            else if (userInput.equals("4")) {
                printAllTasks();
            }
            return true;
        }
        else {
            System.out.println("Unknown input \n");
            return false;
        }
    }

    // Saves a binary version of the TaskList to a given file.
    // The file is saved relative to the current project folder.
    public void saveToFile() {
        Path destination = Paths.get(FILE_NAME).toAbsolutePath();
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(destination.toString()));
            os.writeObject(taskList);

            os.close();
        }
        catch (IOException exc) {
            System.err.println("Error saving to file" );
            exc.printStackTrace();
        }
    }

    // Reads a TaskList object from a file.
    public void loadFromFile() {
        Path destination = Paths.get(FILE_NAME).toAbsolutePath();
        try {
            File file = destination.toFile();
            if (file.exists())
            {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
                this.taskList = (TaskList)is.readObject();
                is.close();
            }
        }
        catch (Exception e) {
            System.err.println("Error when loading file");
            e.printStackTrace();
        }
    }

    // Main command loop.
    // Prints the menu and waits for user input until the user chooses to quit.
    public void run() {
        loadFromFile();
        printWelcomeMessage();
        boolean quit = false;
        while (!quit) {
            cli.printMainMenu();
            String userInput = cli.readUserInput();
            quit = processMainMenuInput(userInput);
        }
        saveToFile();
    }

    public static void main(String[] args) {
        ToDolyApp app = new ToDolyApp();
        app.run();
    }
}

