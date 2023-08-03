package com.Gleb.operations;

public class MultiplicationStrategy implements IOperationStrategy {
    @Override
    public double run(int arg1, int arg2) {
        return arg1 * arg2;
    }
}
