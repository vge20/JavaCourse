package com.Gleb;

import com.Gleb.exceptions.InvalidOperationException;

import java.math.BigDecimal;

public class Main
{
    public static void main( String[] args ) {
        AppConfig appConfig = new AppConfig();
        InputScanner inputScanner = appConfig.getInputScanner();
        OperationExecutor operationExecutor = appConfig.getOperationExecutor();
        Validator validator = appConfig.getValidator();
        CalcArgs calcArgs;
        OperationsEnum operation;
        BigDecimal res;

        while (true) {
            calcArgs = inputScanner.scan();
            if (calcArgs == null) { return; }

            try {
                operation = OperationsEnum.determineOperation(calcArgs.getOperation());
            }
            catch (InvalidOperationException e) {
            System.out.println("Такой операции не предусмотрено!");
                return;
            }

            if (!validator.validateOperation(operation, calcArgs.getArg1(), calcArgs.getArg2())) {
                return;
            }

            res = operationExecutor.runOperation(calcArgs, operation);
            if (res == null) {
                return;
            }

            System.out.println(res);
        }
    }
}
