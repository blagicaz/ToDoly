package com.todoly;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskListTest {

    private TaskList createTaskList() {
        Task t1 = new Task("test task 1", new Date(), "project 1" );
        Task t2 = new Task("test task 2", new Date(), "project 2" );
        Task t3 = new Task("test task 3", new Date(), "project 3" );
        Task t4 = new Task("test task 4", new Date(), "project 4" );
        TaskList taskList = new TaskList();
        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
        return taskList;
    }

    @Test
    public void testValidIndexOnEmptyList() {
        TaskList taskList = new TaskList();

        assertFalse(taskList.validIndex(0));
        assertFalse(taskList.validIndex(3));
        assertFalse(taskList.validIndex(19));
    }

    @Test
    public void testValidIndex() {
        TaskList taskList = createTaskList();

        assertEquals(true, taskList.validIndex(0));
        assertTrue(taskList.validIndex(0));
        assertTrue(taskList.validIndex(3));
        assertFalse(taskList.validIndex(19));
        assertFalse(taskList.validIndex(-1));
    }

    @Test
    public void testNumberDoneOnEmptyList() {
        TaskList taskList = new TaskList();

        int num = taskList.numberDone();
        assertEquals(0, num);
    }

    @Test
    public void testNumberDone() {
        TaskList taskList = createTaskList();

        assertEquals(0, taskList.numberDone());

        taskList.getTasks().get(0).setComplete(true);
        assertEquals(1, taskList.numberDone());

        taskList.getTasks().get(1).setComplete(true);
        assertEquals(2, taskList.numberDone());
    }

    @Test
    public void testNumberNotDoneOnEmptyList() {
        TaskList taskList = new TaskList();

        int num = taskList.numberNotDone();
        assertEquals(0, num);
    }

    @Test
    public void testNumberNotDone() {
        TaskList taskList = createTaskList();

        assertEquals(4, taskList.numberNotDone());

        taskList.getTasks().get(0).setComplete(true);
        assertEquals(3, taskList.numberNotDone());

        taskList.getTasks().get(1).setComplete(true);
        assertEquals(2, taskList.numberNotDone());
    }
}
