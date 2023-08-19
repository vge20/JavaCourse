package com.Gleb.operations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivisionStrategy implements IOperationStrategy {
    @Override
    public BigDecimal run(BigDecimal arg1, BigDecimal arg2) {
        return arg1.divide(arg2, 3, RoundingMode.HALF_DOWN);
    }
}
