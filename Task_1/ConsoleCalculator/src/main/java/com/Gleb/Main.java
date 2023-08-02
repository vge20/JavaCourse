package com.Gleb;

import com.Gleb.Factories.OperationsFactory;
import com.Gleb.Handlers.ValidationHandler;
import com.beust.jcommander.JCommander;

public class Main
{
    public static void main( String[] args ) {
        CalculateArgs calcArgs = new CalculateArgs();
        JCommander.newBuilder().addObject(calcArgs).build().parse(args);

        OperationsEnum operation = OperationsEnum.determineOperation(calcArgs.getOperation());
        if (operation == OperationsEnum.INVALID_OPERATION) {
            System.out.println("Такой операции не предусмотрено!");
            return;
        }

        ValidationHandler validationHandler = new ValidationHandler();
        if (!validationHandler.validateOperation(operation, calcArgs.getArg1(), calcArgs.getArg2())) {
            return;
        }
        OperationsFactory operationsFactory = new OperationsFactory();
        System.out.println(operationsFactory.getOperation(operation).run(calcArgs.getArg1(), calcArgs.getArg2()));
    }
}
