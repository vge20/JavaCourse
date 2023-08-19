package com.Gleb.validations;

import com.Gleb.exceptions.DivisionByZeroException;

import java.math.BigDecimal;

public class DivisionValidationStrategy implements IValidationStrategy {
    @Override
    public void validate(BigDecimal arg1, BigDecimal arg2) throws DivisionByZeroException {
        if (arg2.equals(0)) { throw new DivisionByZeroException(); }
    }
}
