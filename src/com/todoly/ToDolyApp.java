package com.todoly;

public class ToDolyApp {

    private TaskList list;
    private CLI cli;

    public ToDolyApp() {
        list = new TaskList();
        cli = new CLI();
    }

    public void tempCreateTasks() {
        Task t1 = new Task("buy beer");
        t1.setComplete(true);
        Task t2 = new Task("clean bike");
        Task t3 = new Task("do laundry");
        t3.setComplete(true);
        Task t4 = new Task("watch tv");

        TaskList list = new TaskList();

        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);
        list.addTask(t4);

        list.listTasks();
    }

    public boolean processInput(String userInput) {
        boolean quit = false;

        if (cli.validInput(userInput)) {
            if (userInput.equals("1")) {
                System.out.println("show tasks");
            }
            else if (userInput.equals("2")) {
                System.out.println("add new task");
            }
            else if (userInput.equals("3")) {
                System.out.println("Exiting app");
                quit = true;
            }

        } else {
            System.out.println("unknown input");
        }

        return quit;
    }

    public void run() {
        boolean quit = false;
        while (!quit) {
            cli.printMenu();
            String userInput = cli.readUserInput();
            quit = processInput(userInput);
        }
    }

    public static void main(String[] args) {

//        CLI cli = new CLI();

//        cli.printMenu();
//        cli.readUserInput();
//        cli.processInput();.run();

        ToDolyApp app = new ToDolyApp();
        app.tempCreateTasks();
        app.run();


    }

}

