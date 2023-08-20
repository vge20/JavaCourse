package com.Gleb;

import com.Gleb.operations.OperationStrategyProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfig {
    private OperationStrategyProxy operationStrategy;

    public AppConfig() {
        operationStrategy = new OperationStrategyProxy();
    }

    @Bean
    public InputScanner getInputScanner() {
        return new InputScanner(operationStrategy, new Scanner(System.in), new CalcArgs());
    }

    @Bean
    public OperationExecutor getOperationExecutor() {
        return new OperationExecutor(operationStrategy);
    }

    @Bean
    public Validator getValidator() {
        return new Validator();
    }
}
