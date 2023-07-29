package com.Gleb.operations;

public class Division implements IOperation {
    @Override
    public double run(int arg1, int arg2) {
        return (double) arg1 / arg2;
    }
}
