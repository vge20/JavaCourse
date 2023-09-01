package com.Gleb.containers;

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
import lombok.Getter;

@Getter
public class CarsDIContainer {

    private Service<Car> carsService;

    private RequestParser requestParser;

    private Converter<Car> carsConverter;

    private Validator carsValidator;

    private Repository<Car> carsRepository;

    public CarsDIContainer() {
        this.requestParser = new RequestParser();
        this.carsRepository = new CarsRepository();
        this.carsService = new CarsService(carsRepository);
        this.carsConverter = new CarsConverter();
        this.carsValidator = new CarsValidator();
    }
}
