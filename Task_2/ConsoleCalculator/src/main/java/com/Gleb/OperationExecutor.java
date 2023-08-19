package com.Gleb.handlers;

import com.Gleb.CalcArgs;
import com.Gleb.operations.OperationStrategyProxy;
import com.Gleb.OperationsEnum;

import java.math.BigDecimal;

public class OperationHandler {
    OperationStrategyProxy operationStrategy;

    public OperationHandler(OperationStrategyProxy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public BigDecimal runOperation(CalcArgs calcArgs, OperationsEnum operation) {
        operationStrategy.setOperation(operation);
        BigDecimal res = operationStrategy.run(calcArgs.getArg1(), calcArgs.getArg2());

        if (res == null) { System.out.println("Такой операции не предусмотрено!"); }

        return res;
    }
}
