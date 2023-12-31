package com.Gleb.services;

import com.Gleb.entities.Car;
import com.Gleb.repositories.Repository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class CarsService implements Service {

    private Repository<Car> carsRepository;

    @Override
    public Object executeGet(int id) throws SQLException {
        return this.carsRepository.getById(id);
    }

    @Override
    public void executeAdd(Object entity) throws SQLException {
        this.carsRepository.add((Car) entity);
    }

    @Override
    public void executeUpdate(Object entity) throws SQLException {
        Car car = (Car) entity;
        if (this.carsRepository.getById(car.getId()) == null) {
            this.carsRepository.addWithId(car);
        }
        else {
            this.carsRepository.update(car);
        }
    }

    @Override
    public void executeDelete(int id) throws SQLException {
        this.carsRepository.delete(id);
    }
}
