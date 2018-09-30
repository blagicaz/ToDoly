package com.todoly;

import java.util.Scanner;

public class CLI {
    private Scanner reader;
    private static final String[] VALID_MAIN_INPUTS = {"1", "2", "3", "4",};
    private static final String[] VALID_EDIT_INPUTS = {"1", "2", "3", "4", "5", "6"};

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
        System.out.println(">> (3) Edit / Remove Task");
        System.out.println(">> (4) Quit");
        System.out.print("> ");
    }

    public void printEditOptions() {
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Mark as done");
        System.out.println(">> (2) Mark as not done");
        System.out.println(">> (3) Edit Task Title");
        System.out.println(">> (4) Edit Due Date");
        System.out.println(">> (5) Edit Task project");
        System.out.println(">> (6) Remove Task");
        System.out.print("> ");

    }

    //Prints all the tasks stored in the taskList with their index number
    public void printTasks(TaskList taskList) {
        int counter = 0;
        for (Task task : taskList.getTasks()) {
            System.out.println(counter);
            System.out.println(task.toString());
            counter ++;
        }
    }

    public String readUserInput() {
        String inputLine = reader.nextLine();
        return inputLine;
    }

    public boolean validMainInput(String userInput) {
        boolean valid = validInput(userInput, VALID_MAIN_INPUTS);
        return valid;
    }

    public boolean validEditInput(String userInput) {
        boolean valid = validInput(userInput, VALID_EDIT_INPUTS);
        return valid;
    }

    // Checks whether the user input is one of the valid inputs.
    // Returns true if it is, false otherwise.
    private boolean validInput(String userInput, String[] validInputs) {
        if (userInput == null) {
            return false;
        }
        for (String item : validInputs) {
            if (item.equals(userInput)) {
                return true;
            }
        }
        return false;
    }

}
