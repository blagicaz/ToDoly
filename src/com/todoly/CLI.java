package com.todoly;

import java.util.Scanner;

public class CLI {

    private String userInput;
    private Scanner reader;
    private static final String[] VALID_INPUTS = {"1", "2", "3"};

    public CLI() {
        reader = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println();
        System.out.println(">> Welcome to ToDoly");
        System.out.println(">> You have X tasks todo and Y tasks are done!");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Quit");
        System.out.print("> ");
    }

    public String readUserInput() {
        String inputLine = reader.nextLine();
        userInput = inputLine;
        return userInput;
    }

    private boolean validInput() {
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

    public boolean processInput() {
        boolean valid;

        if (validInput()) {
            if (userInput.equals("1")) {
                System.out.println("ok");
            }
            else if (userInput.equals("2")) {
                System.out.println("ok");
            }
            else if (userInput.equals("3")) {
                System.out.println("ok");
            }
            valid = true;
        }
        else {
            System.out.println("unknown input");
            valid = false;
        }

        return valid;
    }

    public void run() {

        boolean valid = false;
        while (!valid) {
            printMenu();
            readUserInput();
            valid = processInput();
        }

    }

}
