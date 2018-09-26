package com.todoly;

public class ToDolyApp {

    public static void main(String[] args) {

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

        CLI cli = new CLI();
//        cli.printMenu();
//        cli.readUserInput();
//        cli.processInput();
        cli.run();

    }
}
