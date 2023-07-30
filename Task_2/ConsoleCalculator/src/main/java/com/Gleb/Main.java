package com.Gleb;

import com.Gleb.operations.OperationStrategyProxy;

import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args ) {
        int arg1, arg2;
        char operation;
        String tmpOperation;
        Scanner consoleScanner = new Scanner(System.in);
        Scanner parser;
        LinkedList<String> operationsList;
        OperationStrategyProxy operationStrategy = new OperationStrategyProxy();

        while (true) {
            if (consoleScanner.hasNextLine()) {
                parser = new Scanner(consoleScanner.nextLine());
            }
            else {
                System.out.println("Некорректный ввод!\n");
                return;
            }

            if (!parser.hasNextInt()) {
                if (parser.next().equals("/end")) {
                    operationsList = operationStrategy.getOperationsList();
                    for (String str : operationsList) {
                        System.out.println(str);
                    }
                }
                else {
                    System.out.println("Некорректный ввод!\n");
                }
                return;
            }

            if (parser.hasNextInt()) {
                arg1 = parser.nextInt();
            }
            else {
                System.out.println("Некорректный ввод!\n");
                return;
            }

            if (parser.hasNext()) {
                tmpOperation = parser.next();
            }
            else {
                System.out.println("Некорректный ввод!\n");
                return;
            }

            if (tmpOperation.length() != 1) {
                System.out.println("Некорректный ввод!\n");
                return;
            }

            operation = tmpOperation.charAt(0);

            if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                System.out.println("Некорректный ввод!\n");
                return;
            }

            if (parser.hasNextInt()) {
                arg2 = parser.nextInt();
            }
            else {
                System.out.println("Некорректный ввод!\n");
                return;
            }

            if (parser.hasNext()) {
                System.out.println("Некорректный ввод!\n");
                return;
            }

            operationStrategy.setOperation(operation);
            System.out.println(operationStrategy.run(arg1, arg2));
            }
    }
}
