package com.Gleb.Handlers;

import com.Gleb.CalcArgs;
import com.Gleb.Operations.IOperationStrategy;
import com.Gleb.Operations.OperationStrategyProxy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class InputHandler {

    public InputHandler(OperationStrategyProxy operationStrategy) {
        this.consoleScanner = new Scanner(System.in);
        this.operationStrategy = operationStrategy;
        this.END_STRING = "/end";
    }

    private int arg1, arg2;
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

        if (!parser.hasNextInt()) {
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

        if (parser.hasNextInt()) {
            arg1 = parser.nextInt();
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

        if (parser.hasNextInt()) {
            arg2 = parser.nextInt();
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
