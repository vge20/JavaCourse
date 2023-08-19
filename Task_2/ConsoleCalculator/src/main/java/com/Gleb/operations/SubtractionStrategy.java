package com.Gleb.operations;

import java.math.BigDecimal;

public class SubtractionStrategy implements OperationStrategy {
    @Override
    public BigDecimal execute(BigDecimal arg1, BigDecimal arg2) {
        return arg1.subtract(arg2);
    }
}
