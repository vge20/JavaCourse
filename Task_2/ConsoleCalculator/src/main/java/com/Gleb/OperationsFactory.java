package com.Gleb;

import com.Gleb.operations.*;

public class OperationsFactory {

    public IOperationStrategy getOperation(OperationsEnum operation) {
        if (operation == OperationsEnum.DIV) {
            return new DivisionStrategy();
        }
        else if (operation == OperationsEnum.MUL) {
            return new MultiplicationStrategy();
        }
        else if (operation == OperationsEnum.SUB) {
            return new SubtractionStrategy();
        }
        else {
            return new SummationStrategy();
        }
    }
}
