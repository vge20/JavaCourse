package com.Gleb.context;

import com.Gleb.RequestParser;
import com.Gleb.converters.CarsConverter;
import com.Gleb.converters.Converter;
import com.Gleb.entities.Car;
import com.Gleb.repositories.CarsRepository;
import com.Gleb.repositories.Repository;
import com.Gleb.services.CarsService;
import com.Gleb.services.Service;
import com.Gleb.validators.CarsValidator;
import com.Gleb.validators.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {

    private RequestParser requestParser;

    private Service<Car> carsService;

    private Converter<Car> carsConverter;

    private Validator carsValidator;

    private ContextContainer<Car> carContextContainer;

    public ContextConfig() {
        this.requestParser = new RequestParser();
        this.carsService = new CarsService(new CarsRepository());
        this.carsConverter = new CarsConverter();
        this.carsValidator = new CarsValidator();
        this.carContextContainer = new ContextContainer<>(carsService,
                requestParser, carsConverter, carsValidator);
    }

    @Bean
    public ContextContainer<Car> getContextContainer() {
        return this.carContextContainer;
    }
}
