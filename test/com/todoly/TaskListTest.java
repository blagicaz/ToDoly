package com.todoly;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskListTest {

    private TaskList emptyTaskList;
    private TaskList taskList;

    @Before
    public void setUp() {
        emptyTaskList = new TaskList();
        taskList = new TaskList();

        Task t1 = new Task("test task 1", new Date(), "project 1" );
        Task t2 = new Task("test task 2", new Date(), "project 2" );
        Task t3 = new Task("test task 3", new Date(), "project 3" );
        Task t4 = new Task("test task 4", new Date(), "project 4" );

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
    }

    @Test
    public void testValidIndex() {
        // Test on a empty taskList
        assertFalse(emptyTaskList.validIndex(0));
        assertFalse(emptyTaskList.validIndex(3));
        assertFalse(emptyTaskList.validIndex(19));

        // Tests with some tasks
        assertEquals(true, taskList.validIndex(0));
        assertTrue(taskList.validIndex(0));
        assertTrue(taskList.validIndex(3));
        assertFalse(taskList.validIndex(19));
        assertFalse(taskList.validIndex(-1));
    }

    @Test
    public void testNumberDone() {
        // Test on a empty taskList
        int num = emptyTaskList.numberDone();
        assertEquals(0, num);

        // Tests with completed tasks
        assertEquals(0, taskList.numberDone());
        taskList.getTasks().get(0).setComplete(true);
        assertEquals(1, taskList.numberDone());
        taskList.getTasks().get(1).setComplete(true);
        assertEquals(2, taskList.numberDone());
    }

    @Test
    public void testNumberNotDone() {
        // Test on a empty taskList
        int num = emptyTaskList.numberNotDone();
        assertEquals(0, num);

        // Tests with not completed tasks
        assertEquals(4, taskList.numberNotDone());
        taskList.getTasks().get(0).setComplete(true);
        assertEquals(3, taskList.numberNotDone());
        taskList.getTasks().get(1).setComplete(true);
        assertEquals(2, taskList.numberNotDone());
    }

    @Test
    public void testNotDoneTasks() {
        // Test on a empty taskList
        ArrayList<Task> result = emptyTaskList.notDoneTasks();
        assertTrue(result.isEmpty());

        // Tests with not completed tasks
        result = taskList.notDoneTasks();
        assertEquals(4, result.size());

        // Test if the the result list has the correct size
        taskList.getTasks().get(0).setComplete(true);
        taskList.getTasks().get(1).setComplete(true);
        result = taskList.notDoneTasks();
        assertEquals(2, result.size());

        // Test if all the tasks in the result are not complete
        assertFalse(result.get(0).getComplete());
        assertFalse(result.get(1).getComplete());
    }

    @Test
    public void testFilterByProject() {
        ArrayList<Task> result = taskList.filterByProject("project 1");
        assertEquals(1, result.size());
        assertEquals("project 1", result.get(0).getProject());
    }
}
