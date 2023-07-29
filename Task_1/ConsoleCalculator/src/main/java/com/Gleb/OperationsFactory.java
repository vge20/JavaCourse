package com.Gleb;

import com.Gleb.operations.*;

public class OperationsFactory {

    public IOperation getOperation(OperationsEnum operation) {
        if (operation == OperationsEnum.DIV) {
            return new Division();
        }
        else if (operation == OperationsEnum.MUL) {
            return new Multiplication();
        }
        else if (operation == OperationsEnum.SUB) {
            return new Subtraction();
        }
        else {
            return new Summation();
        }
    }
}
