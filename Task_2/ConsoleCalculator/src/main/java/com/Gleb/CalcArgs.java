package com.Gleb;

import java.math.BigDecimal;

public class CalcArgs {
    public CalcArgs() {}

    public CalcArgs(BigDecimal arg1, BigDecimal arg2, char operation) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.operation = operation;
    }

    private BigDecimal arg1;

    private BigDecimal arg2;

    private char operation;

    public BigDecimal getArg1() {
        return arg1;
    }

    public void setArg1(BigDecimal arg1) {
        this.arg1 = arg1;
    }

    public BigDecimal getArg2() {
        return arg2;
    }

    public void setArg2(BigDecimal arg2) {
        this.arg2 = arg2;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }
}
