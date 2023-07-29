package com.Gleb;

import com.beust.jcommander.Parameter;

public class CalculateArgs {
    @Parameter(
            names = "-arg1",
            required = true
    )
    private int arg1;
    @Parameter(
            names = "-arg2",
            required = true
    )
    private int arg2;
    @Parameter(
            names = "-operation",
            required = true
    )
    private String operation;

    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public int getArg2() {
        return arg2;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
