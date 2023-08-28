package com.Gleb.validators;

import com.Gleb.entities.Car;

import java.sql.Date;

public class CarsValidator implements Validator {

    public boolean validateForAdd(Car car) {
        try {
            car.getBrand();
            car.getColor(); // проверка ввода из json
            if (car.getEngineCapacity() < 0) { throw new Exception(); };
        } catch ( Exception e) {
            return false;
        }

        return true;
    }

    public boolean validateForUpdate(Car car) {
        try {
            if (car.getId() < 0) { throw new Exception(); }
            car.getBrand();
            car.getColor(); // проверка ввода из json
            if (car.getEngineCapacity() < 0) { throw new Exception(); };
        } catch ( Exception e) {
            return false;
        }

        return true;
    }
}
