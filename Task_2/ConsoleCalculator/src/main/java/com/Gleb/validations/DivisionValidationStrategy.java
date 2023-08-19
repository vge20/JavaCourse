package com.Gleb.Validations;

import com.Gleb.Exceptions.DivisionByZeroException;

public class DivisionValidationStrategy implements IValidatorStrategy {
    @Override
    public void validate(int arg1, int arg2) throws DivisionByZeroException {
        if (arg2 == 0) { throw new DivisionByZeroException(); }
    }
}
