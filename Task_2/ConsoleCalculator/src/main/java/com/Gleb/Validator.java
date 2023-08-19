package com.Gleb;

import com.Gleb.exceptions.DivisionByZeroException;
import com.Gleb.validations.ValidationStrategy;

import java.math.BigDecimal;

public class Validator {

    private ValidationStrategy validator;

    public boolean validateOperation(OperationsEnum operationsEnum, BigDecimal arg1, BigDecimal arg2) {
        validator = operationsEnum.getValidationStrategy();
        try {
            validator.validate(arg1, arg2);
        } catch (DivisionByZeroException e) {
            System.out.println("Деление на ноль запрещено!");
            return false;
        } catch (Exception e) {
            System.out.println("Некорректный ввод!");
            return false;
        }
        return true;
    }
}
