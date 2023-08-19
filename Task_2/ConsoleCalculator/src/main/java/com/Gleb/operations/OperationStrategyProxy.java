package com.Gleb.operations;

import com.Gleb.OperationsEnum;

import java.math.BigDecimal;
import java.util.LinkedList;

public class OperationStrategyProxy implements OperationStrategy {
    public OperationStrategyProxy() {
        this.operationsList = new LinkedList<String>();
    }
    private LinkedList<String> operationsList;
    private OperationsEnum operation;
    @Override
    public BigDecimal execute(BigDecimal arg1, BigDecimal arg2) {
        OperationStrategy operationStrategy = operation.getOperationStrategy();

        BigDecimal result = operationStrategy.execute(arg1, arg2);

        if (operation.getOperation() == null) { return null; }

        operationsList.add(arg1.toString() + " " + operation.getOperation() + " "
                + arg2.toString() + " = " + result.toString());

        return result;
    }

    public LinkedList<String> getOperationsList() { return operationsList; }

    public void setOperation(OperationsEnum operation) {
        this.operation = operation;
    }
}
