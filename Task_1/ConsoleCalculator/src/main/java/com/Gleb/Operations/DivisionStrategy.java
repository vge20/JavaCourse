package com.Gleb.Operations;

public class DivisionStrategy implements IOperationStrategy {
    @Override
    public double run(int arg1, int arg2) {
        return (double) arg1 / arg2;
    }
}
