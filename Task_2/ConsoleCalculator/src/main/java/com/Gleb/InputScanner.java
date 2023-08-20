package com.Gleb;

import com.Gleb.operations.OperationStrategyProxy;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Scanner;

public class InputScanner {

    public InputScanner(OperationStrategyProxy operationStrategy, Scanner scanner, CalcArgs calcArgs) {
        this.consoleScanner = scanner;
        this.operationStrategy = operationStrategy;
        this.END_STRING = "/end";
        this.calcArgs = calcArgs;
    }

    private CalcArgs calcArgs;
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
            parser = new Scanner(consoleScanner.nextLine()); // тут new нужно, чтобы вторыми сканнером
        }                                                    // распарсить отсканированную строку
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

        calcArgs.setArg1(arg1);
        calcArgs.setArg2(arg2);
        calcArgs.setOperation(operation);
        return calcArgs;
    }
}
