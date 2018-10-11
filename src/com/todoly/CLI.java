/**
 * The CLI class provides helper methods for the command line interface of the ToDolyApp.
 * It provides methods for validating the inputs to the menus.
 */
package com.todoly;

import java.util.Scanner;

public class CLI {
    private Scanner reader;
    private static final String[] VALID_MAIN_MENU_INPUTS = {"1", "2", "3", "4",};
    private static final String[] VALID_EDIT_MENU_INPUTS = {"1", "2", "3", "4", "5", "6"};
    private static final String[] VALID_LIST_MENU_INPUTS = {"1", "2", "3", "4",};

    public CLI() {
        reader = new Scanner(System.in);
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit / Remove Task");
        System.out.println(">> (4) Save and Quit");
        System.out.print("> ");
    }

    public void printEditTaskMenu() {
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Mark as done");
        System.out.println(">> (2) Mark as not done");
        System.out.println(">> (3) Edit Task Title");
        System.out.println(">> (4) Edit Due Date");
        System.out.println(">> (5) Edit Task project");
        System.out.println(">> (6) Remove Task");
        System.out.print("> ");
    }

    public void printListTasksMenu() {
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show not completed tasks ");
        System.out.println(">> (2) Sort tasks by date");
        System.out.println(">> (3) Filter tasks by project");
        System.out.println(">> (4) Show all tasks");
        System.out.print("> ");
    }

    public String readUserInput() {
        String inputLine = reader.nextLine();
        return inputLine;
    }

    /**
     * Checks whether the user input is one of the valid inputs.
     * @param userInput the input that is to be validated
     * @param validInputs all the valid inputs for the menu
     * @return true if userInput is one of the valid inputs, false otherwise
      */
    protected boolean validMenuInput(String userInput, String[] validInputs) {
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

    public boolean validMainMenuInput(String userInput) {
        boolean valid = validMenuInput(userInput, VALID_MAIN_MENU_INPUTS);
        return valid;
    }

    public boolean validEditTaskMenuInput(String userInput) {
        boolean valid = validMenuInput(userInput, VALID_EDIT_MENU_INPUTS);
        return valid;
    }

    public boolean validListTasksMenuInput(String userInput) {
        boolean valid = validMenuInput(userInput, VALID_LIST_MENU_INPUTS);
        return valid;
    }

}
