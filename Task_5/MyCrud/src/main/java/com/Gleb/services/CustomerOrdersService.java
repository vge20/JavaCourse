package com.Gleb.services;

import com.Gleb.entities.Car;
import com.Gleb.entities.Client;
import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.Repository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class CustomerOrdersService implements Service {

    private Repository<CustomerOrder> customerOrdersRepository;

    private Repository<Client> clientsRepository;

    private Repository<Car> carsRepository;

    @Override
    public Object executeGet(int id) throws SQLException {
        CustomerOrder customerOrder = this.customerOrdersRepository.getById(id);
        Client client = this.clientsRepository.getById(customerOrder.getClientId());
        Car car = this.carsRepository.getById(customerOrder.getCarId());
        customerOrder.setFullName(client.getFullName());
        customerOrder.setDateBirth(client.getDateBirth());
        customerOrder.setGender(client.isGender());
        customerOrder.setBrand(car.getBrand());
        customerOrder.setColor(car.getColor());
        customerOrder.setEngineCapacity(car.getEngineCapacity());
        customerOrder.setManufactureDate(car.getManufactureDate());
        customerOrder.setPrice(car.getPrice());

        return customerOrder;
    }

    @Override
    public void executeAdd(Object entity) throws SQLException {
        this.customerOrdersRepository.add((CustomerOrder) entity);
    }

    @Override
    public void executeUpdate(Object entity) throws SQLException {
        CustomerOrder customerOrder = (CustomerOrder) entity;
        if (this.customerOrdersRepository.getById(customerOrder.getId()) == null) {
            this.customerOrdersRepository.addWithId(customerOrder);
        }
        else {
            this.customerOrdersRepository.update(customerOrder);
        }
    }

    @Override
    public void executeDelete(int id) throws SQLException {
        this.customerOrdersRepository.delete(id);
    }
}
