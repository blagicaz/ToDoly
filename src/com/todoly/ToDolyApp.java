package com.todoly;

public class ToDolyApp {

    private TaskList taskList;
    private CLI cli;

    public ToDolyApp() {
        taskList = new TaskList();
        cli = new CLI();
    }

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

    public void createTask() {
        System.out.print("Enter task title: ");
        String title = cli.readUserInput();
        Task t = new Task(title);
        taskList.addTask(t);
        System.out.println("You have created a new task");
    }

    public boolean processInput(String userInput) {
        boolean quit = false;

        if (cli.validInput(userInput)) {
            if (userInput.equals("1")) {
                cli.printTasks(taskList);
            }
            else if (userInput.equals("2")) {
                createTask();
            }
            else if (userInput.equals("3")) {
                System.out.println("Exiting app");
                quit = true;
            }

        }
        else {
            System.out.println("unknown input");
        }

        return quit;
    }

    public void run() {
        cli.printWelcomeMessage();
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

