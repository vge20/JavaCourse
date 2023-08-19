package com.Gleb;

import com.Gleb.exceptions.InvalidOperationException;
import com.Gleb.handlers.InputHandler;
import com.Gleb.handlers.OperationHandler;
import com.Gleb.handlers.ValidationHandler;
import com.Gleb.operations.OperationStrategyProxy;

import java.math.BigDecimal;

public class Main
{
    public static void main( String[] args ) {
        OperationStrategyProxy operationStrategy = new OperationStrategyProxy();
        InputHandler inputHandler = new InputHandler(operationStrategy);
        OperationHandler operationHandler = new OperationHandler(operationStrategy);
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

            ValidationHandler validationHandler = new ValidationHandler();
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
