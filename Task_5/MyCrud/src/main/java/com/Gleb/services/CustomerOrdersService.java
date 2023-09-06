package com.Gleb.services;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.Repository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class CustomerOrdersService implements Service {

    private Repository<CustomerOrder> customerOrdersRepository;

    @Override
    public Object executeGet(int id) throws SQLException {
        return this.customerOrdersRepository.getById(id);
    }

    @Override
    public void executeAdd(Object entity) throws SQLException {
        this.customerOrdersRepository.add((CustomerOrder) entity);
    }

    @Override
    public void executeUpdate(Object entity) throws SQLException {
        this.customerOrdersRepository.update((CustomerOrder) entity);
    }

    @Override
    public void executeDelete(int id) throws SQLException {
        this.customerOrdersRepository.delete(id);
    }
}
