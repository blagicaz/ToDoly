package com.todoly;

public class ToDolyApp {

    private TaskList taskList;
    private CLI cli;

    public ToDolyApp() {
        taskList = new TaskList();
        cli = new CLI();
    }
    // Temporary method used for testing/to be deleted in future
    public void tempCreateTasks() {
        Task t1 = new Task("buy beer");
        t1.setComplete(true);
        Task t2 = new Task("clean bike");
        Task t3 = new Task("do laundry");
        t3.setComplete(true);
        Task t4 = new Task("watch tv");

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
    }

    public void printWelcomeMessage() {
        int notDone = taskList.numberNotDone();
        int done = taskList.numberDone();
        System.out.println(">> Welcome to ToDoly");
        System.out.println(">> You have "+ notDone + " tasks todo and " + done + " tasks are done!");
    }
    // Create all the tasks with assigned title
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

    public void editTask() {
        cli.printTasks(taskList);
        boolean valid = false;
        while (valid == false) {
            System.out.print("Enter the number of the task you want to edit => ");
            String indexStr = cli.readUserInput();
            int index = Integer.parseInt(indexStr);

            valid = taskList.validIndex(index);
            if (valid == true) {
                Task task = taskList.getTasks().get(index);
                cli.printEditOptions();
                String userInput = cli.readUserInput();
                processEditMenu(task, index, userInput);
                System.out.println("Task has been successfully edited");
            }
            else {
                System.out.println("Invalid index. Can't edit task");
            }
        }
    }

    public void processEditMenu(Task task, int taskIndex, String userInput) {

        if (cli.validEditInput(userInput)) {
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
        }
        else {
            System.out.println("Unknown input");
        }
    }

    // Processing the user input.
    // Return true if the user choose to quit, false for all the other options.
    public boolean processInput(String userInput) {
        boolean quit = false;

        if (cli.validMainInput(userInput)) {
            if (userInput.equals("1")) {
                cli.printTasks(taskList);
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

    // Main command loop.
    // Prints the menu and waits for user input until the user chooses to quit.
    public void run() {
        printWelcomeMessage();
        boolean quit = false;
        while (!quit) {
            cli.printMenuOptions();
            String userInput = cli.readUserInput();
            quit = processInput(userInput);
        }
    }

    public static void main(String[] args) {

        ToDolyApp app = new ToDolyApp();
        app.tempCreateTasks();
        app.run();
    }
}

