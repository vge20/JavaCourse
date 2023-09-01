package com.Gleb.services;

import com.Gleb.entities.Car;
import com.Gleb.repositories.CarsRepository;
import com.Gleb.repositories.Repository;

import java.sql.SQLException;

public class CarsService {

    private Repository<Car> carsRepository;

    public CarsService() {
        this.carsRepository = new CarsRepository();
    }

    public Car getCar(int id) throws Exception {
        return carsRepository.getById(id);
    }

    public void addCar(Car car) throws SQLException {
        carsRepository.add(car);
    }

    public void updateCar(Car car) throws SQLException {
        carsRepository.update(car);
    }

    public void deleteCar(int id) throws Exception {
        carsRepository.delete(id);
    }
}
