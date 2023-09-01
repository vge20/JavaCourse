package com.Gleb.services;

import com.Gleb.entities.Car;
import com.Gleb.exceptions.WorkingWithDBException;
import com.Gleb.repositories.CarsRepository;
import com.Gleb.repositories.Repository;

public class CarsService implements Service {

    private Repository<Car> carsRepository;

    public CarsService() {
        this.carsRepository = new CarsRepository();
    }

    @Override
    public Object get(int id) throws WorkingWithDBException {
        try {
            return carsRepository.getById(id);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void add(Object entity) throws WorkingWithDBException {
        try {
            carsRepository.add((Car) entity);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void update(Object entity) throws WorkingWithDBException {
        try {
            carsRepository.update((Car) entity);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void delete(int id) throws WorkingWithDBException {
        try {
            carsRepository.delete(id);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }
}
