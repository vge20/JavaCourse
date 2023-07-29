package com.Gleb;

import com.beust.jcommander.JCommander;

public class Main
{
    public static void main( String[] args ) {
        CalculateArgs calcArgs = new CalculateArgs();
        JCommander.newBuilder().addObject(calcArgs).build().parse(args);

        OperationsEnum operation;
        if (calcArgs.getOperation().equals("div")) {
            operation = OperationsEnum.DIV;
        }
        else if (calcArgs.getOperation().equals("mul")) {
            operation = OperationsEnum.MUL;
        }
        else if (calcArgs.getOperation().equals("sum")) {
            operation = OperationsEnum.SUM;
        }
        else if (calcArgs.getOperation().equals("sub")) {
            operation = OperationsEnum.SUB;
        }
        else {
            System.out.println("Некорректный тип операции!");
            return;
        }

        OperationsFactory operationsFactory = new OperationsFactory();
        System.out.println(operationsFactory.getOperation(operation).run(calcArgs.getArg1(), calcArgs.getArg2()));
    }
}
