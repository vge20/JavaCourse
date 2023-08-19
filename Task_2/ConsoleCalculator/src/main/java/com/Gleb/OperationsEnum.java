package com.Gleb;

import com.Gleb.exceptions.InvalidOperationException;
import com.Gleb.operations.*;
import com.Gleb.validations.*;

import java.util.HashMap;
import java.util.Map;

public enum OperationsEnum {
    SUM('+', new SummationStrategy(), new SummationValidatorStrategy()),
    SUB('-', new SubtractionStrategy(), new SubtractionValidationStrategy()),
    MUL('*', new MultiplicationStrategy(), new MultiplicationValidationStrategy()),
    DIV('/', new DivisionStrategy(), new DivisionValidationStrategy());

    private final Character operation;
    private final OperationStrategy operationStrategy;
    private final ValidationStrategy validationStrategy;

    OperationsEnum(Character operation, OperationStrategy operationStrategy,
                   ValidationStrategy validationStrategy) {
        this.operation = operation;
        this.operationStrategy = operationStrategy;
        this.validationStrategy = validationStrategy;
    }

    public Character getOperation() { return operation; }
    public OperationStrategy getOperationStrategy() { return operationStrategy; }
    public ValidationStrategy getValidationStrategy() { return validationStrategy; }

    public static Map<Character, OperationsEnum> operationsEnumMap = new HashMap<>();

    public static Map<Character, OperationsEnum> getOperationsMap() {
        operationsEnumMap.clear();
        operationsEnumMap.put('+', OperationsEnum.SUM);
        operationsEnumMap.put('-', OperationsEnum.SUB);
        operationsEnumMap.put('*', OperationsEnum.MUL);
        operationsEnumMap.put('/', OperationsEnum.DIV);

        return operationsEnumMap;
    }

    public static OperationsEnum determineOperation(char operation) throws InvalidOperationException {
        Map<Character, OperationsEnum> operationsEnumMap = OperationsEnum.getOperationsMap();

        OperationsEnum operationEnum = operationsEnumMap.get(operation);
        if (operationEnum == null) { throw new InvalidOperationException(); }


        return operationEnum;
    }
}
