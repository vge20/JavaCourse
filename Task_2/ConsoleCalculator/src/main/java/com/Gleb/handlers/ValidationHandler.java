package com.Gleb.Handlers;

import com.Gleb.Exceptions.DivisionByZeroException;
import com.Gleb.Factories.ValidationsFactory;
import com.Gleb.OperationsEnum;
import com.Gleb.Validations.IValidatorStrategy;

public class ValidationHandler {
    public ValidationHandler() {
        this.validationsFactory = new ValidationsFactory();
    }

    private IValidatorStrategy validator;

    private ValidationsFactory validationsFactory;

    public boolean validateOperation(OperationsEnum operationsEnum, int arg1, int arg2) {
        validator = validationsFactory.getValidator(operationsEnum);
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
