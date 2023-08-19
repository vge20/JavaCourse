package com.Gleb.operations;

import java.math.BigDecimal;

public interface OperationStrategy {
    public BigDecimal execute(BigDecimal arg1, BigDecimal arg2);
}
