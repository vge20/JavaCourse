package com.Gleb;

public class CalcArgs {
    public CalcArgs() {}

    public CalcArgs(int arg1, int arg2, char operation) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.operation = operation;
    }

    private int arg1;

    private int arg2;

    private char operation;

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

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }
}
