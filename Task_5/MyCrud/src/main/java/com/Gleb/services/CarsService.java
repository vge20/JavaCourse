package com.Gleb.services;

import com.Gleb.entities.Car;
import com.Gleb.repositories.CarsRepository;

import java.sql.SQLException;

public class CarsService {

    private CarsRepository carsRepository;

    public CarsService() {
        this.carsRepository = new CarsRepository();
    }

    public Car getCar(int id) throws Exception {
        return carsRepository.getCarById(id);
    }

    public void addCar(Car car) throws SQLException {
        carsRepository.addCar(car);
    }

    public void updateCar(Car car) throws SQLException {
        carsRepository.updateCar(car);
    }

    public void deleteCar(int id) throws Exception {
        carsRepository.deleteCar(id);
    }
}
