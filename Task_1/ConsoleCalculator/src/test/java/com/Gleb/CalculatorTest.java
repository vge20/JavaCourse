package com.Gleb;

import com.Gleb.operations.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest
{
    private final int testArg1 = 10;
    private final int testArg2 = 20;
    private IOperation operation;

    @Test
    public void sumTest() {
        operation = new Summation();
        assertEquals((double) testArg1 + testArg2, operation.run(testArg1, testArg2), 1e-6);
    }

    @Test
    public void subTest() {
        operation = new Subtraction();
        assertEquals((double) testArg1 - testArg2, operation.run(testArg1, testArg2), 1e-6);
    }

    @Test
    public void divTest() {
        operation = new Division();
        assertEquals((double) testArg1 / testArg2, operation.run(testArg1, testArg2), 1e-6);
    }

    @Test
    public void mulTest() {
        operation = new Multiplication();
        assertEquals((double) testArg1 * testArg2, operation.run(testArg1, testArg2), 1e-6);
    }
}
