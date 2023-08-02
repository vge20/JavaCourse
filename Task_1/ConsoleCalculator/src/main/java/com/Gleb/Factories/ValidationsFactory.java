package com.Gleb.Factories;

import com.Gleb.Operations.DivisionStrategy;
import com.Gleb.Operations.MultiplicationStrategy;
import com.Gleb.Operations.SubtractionStrategy;
import com.Gleb.Operations.SummationStrategy;
import com.Gleb.OperationsEnum;
import com.Gleb.Validations.*;

public class ValidationsFactory {

    public IValidatorStrategy getValidator(OperationsEnum operation) {
        if (operation == OperationsEnum.DIV) {
            return new DivisionValidationStrategy();
        }
        else if (operation == OperationsEnum.MUL) {
            return new MultiplicationValidationStrategy();
        }
        else if (operation == OperationsEnum.SUB) {
            return new SubtractionValidationStrategy();
        }
        else {
            return new SummationValidatorStrategy();
        }
    }
}
