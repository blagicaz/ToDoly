# ToDoly
ToDoly is a todo list application written in Java that uses a text based user interface. 
[Class Diagram](https://github.com/blagicaz/ToDoly/blob/master/Class%20Diagram%20-%20Version%201.pdf)
## Prerequisites
Java version 8+

## Description
The project is a simple application that supports listing, creating, editing and removing tasks from the task list.
The tasks are saved and loaded from a file on disk.

## Running the app 

- Download (and unpack) the code
- In the terminal go to the `src` directory in the project directory
- Compile the code
```sh
javac com/todoly/*.java
```
- To start the application, run the main `ToDolyApp` class.
```sh
java com/todoly/ToDolyApp
```

## User Manual
To use the ToDoly, follow the instructions:

- Select an option from the main menu:
```sh
 >> Pick an option:
 >> (1) Show Task List
 >> (2) Add New Task
 >> (3) Edit / Remove Task
 >> (4) Save and Quit
 > 
```
#### Listing tasks
- For listing the tasks, choose option number `1`.
A submenu with 4 options is displayed: it can list the not completed tasks, sort them by date, filter by project or show a list of all tasks.
```sh
>> (1) Show not completed tasks 
>> (2) Sort tasks by date
>> (3) Filter tasks by project
>> (4) Show all tasks
> 
```

#### Creating tasks
- For creating a new task, choose option number `2`. 
In order to create/add a task all the required fields must be entered:
```sh
Enter task title: 
Enter task project: 
Enter due date (format: YYYY-MM-DD): 
```
The task status is automatically set to not complete, when is created.

#### Editing tasks
- For editing tasks, choose option number `3`. 
A list of all tasks is printed in order to choose a task that should be edited.
When the task is chosen, a submenu with 6 options is displayed:
```sh
>> Pick an option:
>> (1) Mark as done
>> (2) Mark as not done
>> (3) Edit Task Title
>> (4) Edit Due Date
>> (5) Edit Task project
>> (6) Remove Task
> 
```

#### Saving and exiting
- All the created tasks and all the changes made while the application is running,
will be saved when option number `4` is chosen.


## Running the tests
The todoly package contains tests in JUnit. 
There are two classes `TaskListTest` class and `CLITest` class that test the methods of `TaskList` and `CLI` classes.


## Author
> Blagica Zafirovska
> Individual project - part of SDA 4 