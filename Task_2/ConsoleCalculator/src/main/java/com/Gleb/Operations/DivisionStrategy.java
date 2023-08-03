package com.Gleb.Operations;

import java.math.BigDecimal;

public class DivisionStrategy implements IOperationStrategy {
    @Override
    public BigDecimal run(int arg1, int arg2) {
        return BigDecimal.valueOf(arg1 / arg2);
    }
}
