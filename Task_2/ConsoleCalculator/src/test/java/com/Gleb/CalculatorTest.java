package com.Gleb;

import com.Gleb.operations.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculatorTest
{
    private final BigDecimal testArg1 = BigDecimal.valueOf(10);
    private final BigDecimal testArg2 = BigDecimal.valueOf(20);
    private IOperationStrategy operation;

    @Test
    public void sumTest() {
        operation = new SummationStrategy();
        assertEquals(testArg1.add(testArg2), operation.run(testArg1, testArg2));
    }

    @Test
    public void subTest() {
        operation = new SubtractionStrategy();
        assertEquals(testArg1.subtract(testArg2), operation.run(testArg1, testArg2));
    }

    @Test
    public void divTest() {
        operation = new DivisionStrategy();
        assertEquals(testArg1.divide(testArg2), operation.run(testArg1, testArg2));
    }

    @Test
    public void mulTest() {
        operation = new MultiplicationStrategy();
        assertEquals(testArg1.multiply(testArg2), operation.run(testArg1, testArg2));
    }
}
