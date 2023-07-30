package com.Gleb.operations;

import java.util.LinkedList;

public class OperationStrategyProxy implements IOperationStrategy{
    public OperationStrategyProxy(IOperationStrategy operationStrategy, String mathOperation) {
        this.operationStrategy = operationStrategy;
        this.operationsList = new LinkedList<String>();
        this.mathOperation = mathOperation;
    }
    private IOperationStrategy operationStrategy;
    private LinkedList<String> operationsList;
    private String mathOperation;
    @Override
    public double run(int arg1, int arg2) {
        double result = operationStrategy.run(arg1, arg2);

        String operation = null;
        if (this.mathOperation.equals("sum")) { operation = "+"; }
        else if (this.mathOperation.equals("sub")) { operation = "-"; }
        else if (this.mathOperation.equals("mul")) { operation = "*"; }
        else { operation = "/"; }

        operationsList.add(Integer.toString(arg1) + " " + operation + " " + Integer.toString(arg2) + " = "
                + Double.toString(result));

        return result;
    }
}
