package com.Gleb;

import com.Gleb.operations.OperationStrategyProxy;

import java.math.BigDecimal;

public class OperationExecutor {
    OperationStrategyProxy operationStrategy;

    public OperationExecutor(OperationStrategyProxy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public BigDecimal runOperation(CalcArgs calcArgs, OperationsEnum operation) {
        operationStrategy.setOperation(operation);
        BigDecimal res = operationStrategy.execute(calcArgs.getArg1(), calcArgs.getArg2());

        if (res == null) { System.out.println("Такой операции не предусмотрено!"); }

        return res;
    }
}
