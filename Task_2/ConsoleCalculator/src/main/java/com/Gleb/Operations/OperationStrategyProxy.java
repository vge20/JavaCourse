package com.Gleb.operations;

import com.Gleb.OperationsEnum;
import com.Gleb.OperationsFactory;

import java.util.LinkedList;

public class OperationStrategyProxy implements IOperationStrategy{
    public OperationStrategyProxy() {
        this.operationsList = new LinkedList<String>();
    }
    private LinkedList<String> operationsList;
    private char operation;
    @Override
    public double run(int arg1, int arg2) {
        IOperationStrategy operationStrategy;
        if (operation == '+') { operationStrategy = new SummationStrategy(); }
        else if (operation == '-') { operationStrategy = new SubtractionStrategy(); }
        else if (operation == '*') { operationStrategy = new MultiplicationStrategy(); }
        else { operationStrategy = new DivisionStrategy(); }

        double result = operationStrategy.run(arg1, arg2);

        operationsList.add(Integer.toString(arg1) + " " + operation + " " + Integer.toString(arg2) + " = "
                + Double.toString(result));

        return result;
    }

    public LinkedList<String> getOperationsList() { return operationsList; }

    public void setOperation(char operation) {
        this.operation = operation;
    }
}
