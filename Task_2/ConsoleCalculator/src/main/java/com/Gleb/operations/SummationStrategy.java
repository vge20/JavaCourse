package com.Gleb.operations;

import java.math.BigDecimal;

public class SummationStrategy implements IOperationStrategy {
    @Override
    public BigDecimal run(BigDecimal arg1, BigDecimal arg2) {
        return arg1.add(arg2);
    }
}
