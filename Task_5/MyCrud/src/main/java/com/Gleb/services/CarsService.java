package com.Gleb.services;

import com.Gleb.entities.Car;
import com.Gleb.repositories.CarsRepository;

public class CarsService {

    private CarsRepository carsRepository;

    public CarsService() {
        this.carsRepository = new CarsRepository();
    }

    public Car getCar(int id) {
        Car car;
        try {
            car = carsRepository.getCarById(id);
        } catch (Exception e) {
            return null;
        }

        return car;
    }

    public boolean addCar(Car car) {
        try {
            carsRepository.addCar(car);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean updateCar(Car car) {
        try {
            carsRepository.updateCar(car);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean deleteCar(int id) {
        try {
            carsRepository.deleteCar(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
