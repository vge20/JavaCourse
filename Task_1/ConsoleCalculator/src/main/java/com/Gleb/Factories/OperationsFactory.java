package com.Gleb.Factories;

import com.Gleb.Operations.*;
import com.Gleb.OperationsEnum;

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
