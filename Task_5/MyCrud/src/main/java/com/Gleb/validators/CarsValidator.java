package com.Gleb.validators;

import com.Gleb.entities.Car;

import java.sql.Date;

public class CarsValidator implements Validator {

    @Override
    public void validateAddParam(Object entity) throws Exception {
        Car car = (Car) entity;
        car.getBrand();
        car.getColor(); // проверка ввода из json
        if (car.getEngineCapacity() < 0) { throw new Exception(); };
    }

    @Override
    public void validateUpdateParam(Object entity) throws Exception {
        Car car = (Car) entity;
        if (car.getId() < 0) { throw new Exception(); }
        car.getBrand();
        car.getColor(); // проверка ввода из json
        if (car.getEngineCapacity() < 0) { throw new Exception(); };
    }
}
