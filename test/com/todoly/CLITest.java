package com.todoly;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CLITest {

    @Test
    public void testValidMenuInput() {
        CLI cli = new CLI();
        String[] validInputs = {"foo", "bar", "bas"};

        assertFalse(cli.validMenuInput(null, validInputs));
        assertTrue(cli.validMenuInput("foo", validInputs));
        assertFalse(cli.validMenuInput("bla", validInputs));
    }
}
