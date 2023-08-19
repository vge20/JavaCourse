package com.Gleb.operations;

import java.math.BigDecimal;

public interface IOperationStrategy {
    public BigDecimal execute(BigDecimal arg1, BigDecimal arg2);
}
