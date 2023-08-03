package com.Gleb.Operations;

import com.Gleb.Factories.OperationsFactory;
import com.Gleb.OperationsEnum;

import java.math.BigDecimal;
import java.util.LinkedList;

public class OperationStrategyProxy implements IOperationStrategy{
    public OperationStrategyProxy() {
        this.operationsFactory = new OperationsFactory();
        this.operationsList = new LinkedList<String>();
    }
    private LinkedList<String> operationsList;
    private OperationsEnum operation;
    private OperationsFactory operationsFactory;
    @Override
    public BigDecimal run(int arg1, int arg2) {
        IOperationStrategy operationStrategy = operationsFactory.getOperation(operation);

        BigDecimal result = operationStrategy.run(arg1, arg2);

        operationsList.add(Integer.toString(arg1) + " " + OperationsEnum.getCharOperation(operation) + " " + Integer.toString(arg2) + " = "
                + result.toString());

        return result;
    }

    public LinkedList<String> getOperationsList() { return operationsList; }

    public void setOperation(OperationsEnum operation) {
        this.operation = operation;
    }
}
