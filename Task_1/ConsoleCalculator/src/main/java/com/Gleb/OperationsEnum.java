package com.Gleb;

public enum OperationsEnum {
    SUM,
    SUB,
    MUL,
    DIV,
    INVALID_OPERATION;

    public static OperationsEnum determineOperation(String operation) {
        OperationsEnum[] operationsArr = OperationsEnum.values();
        for (int i = 0; i < operationsArr.length - 1; i++) {
            if (operationsArr[i].toString().toLowerCase().equals(operation)) {
                return operationsArr[i];
            }
        }
        return INVALID_OPERATION;
    }

}
