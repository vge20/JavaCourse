package com.Gleb;

import com.Gleb.Handlers.InputHandler;
import com.Gleb.Handlers.ValidationHandler;
import com.Gleb.Operations.IOperationStrategy;
import com.Gleb.Operations.OperationStrategyProxy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args ) {
        OperationStrategyProxy operationStrategy = new OperationStrategyProxy();
        InputHandler inputHandler = new InputHandler(operationStrategy);
        CalcArgs calcArgs;

        while (true) {
            calcArgs = inputHandler.scan();
            if (calcArgs == null) { return; }

            OperationsEnum operation = OperationsEnum.determineOperation(calcArgs.getOperation());
            if (operation == OperationsEnum.INVALID_OPERATION) {
                System.out.println("Такой операции не предусмотрено!");
                return;
            }

            ValidationHandler validationHandler = new ValidationHandler();
            if (!validationHandler.validateOperation(operation, calcArgs.getArg1(), calcArgs.getArg2())) {
                return;
            }

            operationStrategy.setOperation(operation);
            BigDecimal res = operationStrategy.run(calcArgs.getArg1(), calcArgs.getArg2());

            if (res == null) {
                System.out.println("Такой операции не предусмотрено!");
                return;
            }

            System.out.println(res);
            }
    }
}
