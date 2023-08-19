package com.Gleb.operations;

import java.math.BigDecimal;

public class MultiplicationStrategy implements OperationStrategy {
    @Override
    public BigDecimal execute(BigDecimal arg1, BigDecimal arg2) {
        return arg1.multiply(arg2);
    }
}
