package com.Gleb;

import com.Gleb.operations.*;
import com.Gleb.validations.IValidationStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationsContainer {

    public OperationsContainer() {
        this.divisionStrategy = new DivisionStrategy();
        this.multiplicationStrategy = new MultiplicationStrategy();
        this.subtractionStrategy = new SubtractionStrategy();
        this.summationStrategy = new SummationStrategy();
    }

    IOperationStrategy divisionStrategy;
    IOperationStrategy multiplicationStrategy;
    IOperationStrategy summationStrategy;
    IOperationStrategy subtractionStrategy;

    @Bean
    public IOperationStrategy getDivisionStrategy() { return divisionStrategy; }

    @Bean
    public IOperationStrategy getMultiplicationStrategy() { return multiplicationStrategy; }

    @Bean
    public IOperationStrategy getSummationStrategy() { return summationStrategy; }

    @Bean
    public IOperationStrategy getSubtractionStrategy() { return subtractionStrategy; }

    IValidationStrategy divisionValidationStrategy;
    IValidationStrategy multiplicationValidationStrategy;
    IValidationStrategy summationValidatorStrategy;
    IValidationStrategy subtractionValidationStrategy;


}
