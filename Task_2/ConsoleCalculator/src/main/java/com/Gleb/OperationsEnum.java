package com.Gleb;

import java.util.HashMap;
import java.util.Map;

public enum OperationsEnum {
    SUM,
    SUB,
    MUL,
    DIV,
    INVALID_OPERATION;

    public static Map<Character, OperationsEnum> getOperationsMap() {
        Map<Character, OperationsEnum> operationsEnumMap = new HashMap<>();
        operationsEnumMap.put('+', OperationsEnum.SUM);
        operationsEnumMap.put('-', OperationsEnum.SUB);
        operationsEnumMap.put('*', OperationsEnum.MUL);
        operationsEnumMap.put('/', OperationsEnum.DIV);

        return operationsEnumMap;
    }

    public static OperationsEnum determineOperation(char operation) {
        Map<Character, OperationsEnum> operationsEnumMap = OperationsEnum.getOperationsMap();

        OperationsEnum operationEnum = operationsEnumMap.get(operation);
        if (operationEnum == null) { return INVALID_OPERATION; }


        return operationEnum;
    }

    public static Character getCharOperation(OperationsEnum operationsEnum) {
        Map<Character, OperationsEnum> operationsEnumMap = OperationsEnum.getOperationsMap();

        for (Map.Entry<Character, OperationsEnum> entry : operationsEnumMap.entrySet()) {
            if (entry.getValue().equals(operationsEnum)) {
                return entry.getKey();
            }
        }
        
        return null;
    }
}
