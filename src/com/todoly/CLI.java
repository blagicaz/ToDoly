package com.todoly;

import java.util.Scanner;

public class CLI {
    private Scanner reader;
    private static final String[] VALID_INPUTS = {"1", "2", "3"};

    public CLI() {
        reader = new Scanner(System.in);
    }

    public void printWelcomeMessage() {
        System.out.println(">> Welcome to ToDoly");
        System.out.println(">> You have X tasks todo and Y tasks are done!");
    }

    public void printMenuOptions() {
        System.out.println();
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Quit");
        System.out.print("> ");
    }

    public void printTasks(TaskList taskList) {
        for (Task task : taskList.getTasks()) {
            System.out.println(task.toString());
        }
    }

    public String readUserInput() {
        String inputLine = reader.nextLine();
        return inputLine;
    }

    // Checks whether the user input is one of the valid inputs.
    // Returns true if it is, false otherwise.
    public boolean validInput(String userInput) {
        if (userInput == null) {
            return false;
        }
        for (String item : VALID_INPUTS) {
            if (item.equals(userInput)) {
                return true;
            }
        }
        return false;
    }

}
