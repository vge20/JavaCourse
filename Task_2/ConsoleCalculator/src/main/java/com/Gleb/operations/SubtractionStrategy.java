package com.Gleb.operations;

public class SubtractionStrategy implements IOperationStrategy {
    @Override
    public double run(int arg1, int arg2) {
        return arg1 - arg2;
    }
}
