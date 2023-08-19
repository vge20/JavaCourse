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

    IValidationStrategy divisionValidationStrategy;
    IValidationStrategy multiplicationValidationStrategy;
    IValidationStrategy summationValidatorStrategy;
    IValidationStrategy subtractionValidationStrategy;

    @Bean
    public IValidationStrategy getDivisionValidationStrategy() { return divisionValidationStrategy; }

    @Bean
    public IValidationStrategy getMultiplicationValidationStrategy() { return multiplicationValidationStrategy; }

    @Bean
    public IValidationStrategy getSummationValidatorStrategy() { return summationValidatorStrategy; }

    @Bean
    public IValidationStrategy getSubtractionValidationStrategy() { return subtractionValidationStrategy; }
}
