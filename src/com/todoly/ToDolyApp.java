package com.todoly;

public class ToDolyApp {

    private TaskList taskList;
    private CLI cli;

    public ToDolyApp() {
        taskList = new TaskList();
        cli = new CLI();
    }

    // Temporary method used for testing/to be deleted in future.
    public void tempCreateTasks() {
        Task t1 = new Task("buy beer", "2018-10-09", "food");
        t1.setComplete(true);
        Task t2 = new Task("clean bike", "2018-10-10", "work");
        Task t3 = new Task("do laundry", "2018-10-09", "home");
        t3.setComplete(true);
        Task t4 = new Task("watch tv", "2018-10-11", "home");

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

    // Prints all the tasks stored in the taskList with their index number.
    public void printAllTasks() {
        int counter = 0;
        for (Task task : taskList.getTasks()) {
            System.out.println(counter);
            System.out.println(task.toString());
            counter ++;
        }
    }

    public void printNotDoneTasks() {
        for (Task task : taskList.notDoneTasks()) {
            System.out.println(task.toString());
        }
    }

    public void printTasksByProject() {
        System.out.println("Enter project name: ");
        String project = cli.readUserInput();
        for (Task task : taskList.filterByProject(project)) {
            System.out.println(task.toString());
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
            int index = Integer.parseInt(indexStr);

            valid = taskList.validIndex(index);
            if (valid == true) {
                Task task = taskList.getTasks().get(index);
                cli.printEditTaskMenu();
                String userInput = cli.readUserInput();
                processEditTaskMenuInput(task, index, userInput);
                System.out.println("Task has been successfully edited");
            }
            else {
                System.out.println("Invalid index. Can't edit task");
            }
        }
    }

    //Prints the list task submenu and processing the user input.
    public void listTasks() {
        cli.printListTasksMenu();
        String userInput = cli.readUserInput();
        processListTasksMenuInput(userInput);
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
    public void processEditTaskMenuInput(Task task, int taskIndex, String userInput) {

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
        }
        else {
            System.out.println("Unknown input");
        }
    }

    //Processing the user input for the listTask submenu.
    public void processListTasksMenuInput(String userInput) {

        if (cli.validListTasksMenuInput(userInput)) {
            if (userInput.equals("1")) {
                printNotDoneTasks();
            }
            else if (userInput.equals("2")) {

            }
            else if (userInput.equals("3")) {
                printTasksByProject();
            }
            else if (userInput.equals("4")) {
                printAllTasks();
            }
        }
        else {
            System.out.println("Unknown input");
        }
    }

    // Main command loop.
    // Prints the menu and waits for user input until the user chooses to quit.
    public void run() {
        printWelcomeMessage();
        boolean quit = false;
        while (!quit) {
            cli.printMainMenu();
            String userInput = cli.readUserInput();
            quit = processMainMenuInput(userInput);
        }
    }

    public static void main(String[] args) {
        ToDolyApp app = new ToDolyApp();
        app.tempCreateTasks();
        app.run();
    }
}

