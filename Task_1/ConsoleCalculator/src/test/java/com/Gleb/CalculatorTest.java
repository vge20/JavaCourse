package com.Gleb;

import com.Gleb.Operations.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest
{
    private final int testArg1 = 10;
    private final int testArg2 = 20;
    private IOperationStrategy operation;

    @Test
    public void sumTest() {
        operation = new SummationStrategy();
        assertEquals((double) testArg1 + testArg2, operation.run(testArg1, testArg2), 1e-6);
    }

    @Test
    public void subTest() {
        operation = new SubtractionStrategy();
        assertEquals((double) testArg1 - testArg2, operation.run(testArg1, testArg2), 1e-6);
    }

    @Test
    public void divTest() {
        operation = new DivisionStrategy();
        assertEquals((double) testArg1 / testArg2, operation.run(testArg1, testArg2), 1e-6);
    }

    @Test
    public void mulTest() {
        operation = new MultiplicationStrategy();
        assertEquals((double) testArg1 * testArg2, operation.run(testArg1, testArg2), 1e-6);
    }
}
