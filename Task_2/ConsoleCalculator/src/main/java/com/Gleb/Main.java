package com.Gleb;

import com.Gleb.exceptions.InvalidOperationException;
import com.Gleb.operations.OperationStrategyProxy;

import java.math.BigDecimal;

public class Main
{
    public static void main( String[] args ) {
        OperationStrategyProxy operationStrategy = new OperationStrategyProxy();
        InputScanner inputHandler = new InputScanner(operationStrategy);
        OperationExecutor operationHandler = new OperationExecutor(operationStrategy);
        CalcArgs calcArgs;
        OperationsEnum operation;

        while (true) {
            calcArgs = inputHandler.scan();
            if (calcArgs == null) { return; }

            try {
                operation = OperationsEnum.determineOperation(calcArgs.getOperation());
            }
            catch (InvalidOperationException e) {
            System.out.println("Такой операции не предусмотрено!");
                return;
            }

            Validator validationHandler = new Validator();
            if (!validationHandler.validateOperation(operation, calcArgs.getArg1(), calcArgs.getArg2())) {
                return;
            }

            BigDecimal res = operationHandler.runOperation(calcArgs, operation);
            if (res == null) {
                return;
            }

            System.out.println(res);
        }
    }
}
