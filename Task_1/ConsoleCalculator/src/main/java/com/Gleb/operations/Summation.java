package com.Gleb.operations;

import com.Gleb.operations.IOperation;

public class Summation implements IOperation {
    @Override
    public double run(int arg1, int arg2) {
        return arg1 + arg2;
    }
}
