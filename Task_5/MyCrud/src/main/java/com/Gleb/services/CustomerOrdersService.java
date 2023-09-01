package com.Gleb.services;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.CustomerOrdersRepository;
import com.Gleb.repositories.Repository;

import java.sql.SQLException;

public class CustomerOrdersService implements Service {

    private Repository<CustomerOrder> customerOrdersRepository;

    public CustomerOrdersService() {
        customerOrdersRepository = new CustomerOrdersRepository();
    }

    @Override
    public Object get(int id) throws Exception {
        return customerOrdersRepository.getById(id);
    }

    @Override
    public void add(Object entity) throws SQLException {
        customerOrdersRepository.add((CustomerOrder) entity);
    }

    @Override
    public void update(Object entity) throws SQLException {
        customerOrdersRepository.update((CustomerOrder) entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        customerOrdersRepository.delete(id);
    }
}
