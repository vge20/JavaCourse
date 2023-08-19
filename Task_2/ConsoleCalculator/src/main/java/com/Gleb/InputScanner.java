package com.Gleb;

import com.Gleb.operations.OperationStrategyProxy;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Scanner;

public class InputScanner {

    public InputScanner(OperationStrategyProxy operationStrategy) {
        this.consoleScanner = new Scanner(System.in);
        this.operationStrategy = operationStrategy;
        this.END_STRING = "/end";
    }

    private BigDecimal arg1, arg2;
    private char operation;
    private String tmpOperation;
    private Scanner consoleScanner;
    private Scanner parser;
    private LinkedList<String> operationsList;
    private OperationStrategyProxy operationStrategy;
    private final String END_STRING;

    public CalcArgs scan() {
        if (consoleScanner.hasNextLine()) {
            parser = new Scanner(consoleScanner.nextLine());
        }
        else {
            System.out.println("Некорректный ввод!\n");
            return null;
        }

        if (!parser.hasNextBigDecimal()) {
            if (parser.next().equals(END_STRING)) {
                operationsList = operationStrategy.getOperationsList();
                for (String str : operationsList) {
                    System.out.println(str);
                }
            }
            else {
                System.out.println("Некорректный ввод!\n");
            }
            return null;
        }

        if (parser.hasNextBigDecimal()) {
            arg1 = parser.nextBigDecimal();
        }
        else {
            System.out.println("Некорректный ввод!\n");
            return null;
        }

        if (parser.hasNext()) {
            tmpOperation = parser.next();
        }
        else {
            System.out.println("Некорректный ввод!\n");
            return null;
        }

        if (tmpOperation.length() != 1) {
            System.out.println("Некорректный ввод!\n");
            return null;
        }

        operation = tmpOperation.charAt(0);

        if (parser.hasNextBigDecimal()) {
            arg2 = parser.nextBigDecimal();
        }
        else {
            System.out.println("Некорректный ввод!\n");
            return null;
        }

        if (parser.hasNext()) {
            System.out.println("Некорректный ввод!\n");
            return null;
        }

        CalcArgs calcArgs = new CalcArgs(arg1, arg2, operation);
        return calcArgs;
    }
}
