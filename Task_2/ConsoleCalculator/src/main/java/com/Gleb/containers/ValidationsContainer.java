package com.Gleb.containers;

import com.Gleb.validations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationsContainer {

    public ValidationsContainer() {
        this.divisionValidationStrategy = new DivisionValidationStrategy();
        this.multiplicationValidationStrategy = new MultiplicationValidationStrategy();
        this.subtractionValidationStrategy = new SubtractionValidationStrategy();
        this.summationValidatorStrategy = new SummationValidatorStrategy();
    }

    ValidationStrategy divisionValidationStrategy;
    ValidationStrategy multiplicationValidationStrategy;
    ValidationStrategy summationValidatorStrategy;
    ValidationStrategy subtractionValidationStrategy;

    @Bean
    public ValidationStrategy getDivisionValidationStrategy() { return divisionValidationStrategy; }

    @Bean
    public ValidationStrategy getMultiplicationValidationStrategy() { return multiplicationValidationStrategy; }

    @Bean
    public ValidationStrategy getSummationValidatorStrategy() { return summationValidatorStrategy; }

    @Bean
    public ValidationStrategy getSubtractionValidationStrategy() { return subtractionValidationStrategy; }
}
