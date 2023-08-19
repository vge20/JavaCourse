package com.Gleb.validations;

import java.math.BigDecimal;

public interface ValidationStrategy {
    public void validate(BigDecimal arg1, BigDecimal arg2) throws Exception;
}
