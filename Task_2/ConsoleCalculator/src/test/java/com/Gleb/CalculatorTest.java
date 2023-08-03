package com.Gleb;

import com.Gleb.Operations.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculatorTest
{
    private final int testArg1 = 10;
    private final int testArg2 = 20;
    private IOperationStrategy operation;

    @Test
    public void sumTest() {
        operation = new SummationStrategy();
        assertEquals(BigDecimal.valueOf(testArg1 + testArg2), operation.run(testArg1, testArg2));
    }

    @Test
    public void subTest() {
        operation = new SubtractionStrategy();
        assertEquals(BigDecimal.valueOf(testArg1 - testArg2), operation.run(testArg1, testArg2));
    }

    @Test
    public void divTest() {
        operation = new DivisionStrategy();
        assertEquals(BigDecimal.valueOf(testArg1 / testArg2), operation.run(testArg1, testArg2));
    }

    @Test
    public void mulTest() {
        operation = new MultiplicationStrategy();
        assertEquals(BigDecimal.valueOf(testArg1 * testArg2), operation.run(testArg1, testArg2));
    }
}
