package com.Gleb.services;

import com.Gleb.entities.Car;
import com.Gleb.repositories.CarsRepository;
import com.Gleb.repositories.Repository;

import java.sql.SQLException;

public class CarsService implements Service {

    private Repository<Car> carsRepository;

    public CarsService() {
        this.carsRepository = new CarsRepository();
    }

    @Override
    public Object get(int id) throws Exception {
        return carsRepository.getById(id);
    }

    @Override
    public void add(Object entity) throws SQLException {
        carsRepository.add((Car) entity);
    }

    @Override
    public void update(Object entity) throws SQLException {
        carsRepository.update((Car) entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        carsRepository.delete(id);
    }
}
