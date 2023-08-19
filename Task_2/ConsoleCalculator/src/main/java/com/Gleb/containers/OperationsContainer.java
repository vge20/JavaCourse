package com.Gleb.containers;

import com.Gleb.operations.*;
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

    OperationStrategy divisionStrategy;
    OperationStrategy multiplicationStrategy;
    OperationStrategy summationStrategy;
    OperationStrategy subtractionStrategy;

    @Bean
    public OperationStrategy getDivisionStrategy() { return divisionStrategy; }

    @Bean
    public OperationStrategy getMultiplicationStrategy() { return multiplicationStrategy; }

    @Bean
    public OperationStrategy getSummationStrategy() { return summationStrategy; }

    @Bean
    public OperationStrategy getSubtractionStrategy() { return subtractionStrategy; }

}
