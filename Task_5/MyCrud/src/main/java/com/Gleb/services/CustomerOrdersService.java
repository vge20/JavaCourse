package com.Gleb.services;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.exceptions.WorkingWithDBException;
import com.Gleb.repositories.CustomerOrdersRepository;
import com.Gleb.repositories.Repository;

public class CustomerOrdersService implements Service {

    private Repository<CustomerOrder> customerOrdersRepository;

    public CustomerOrdersService() {
        customerOrdersRepository = new CustomerOrdersRepository();
    }

    @Override
    public Object get(int id) throws WorkingWithDBException {
        try {
            return customerOrdersRepository.getById(id);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void add(Object entity) throws WorkingWithDBException {
        try {
            customerOrdersRepository.add((CustomerOrder) entity);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void update(Object entity) throws WorkingWithDBException {
        try {
            customerOrdersRepository.update((CustomerOrder) entity);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void delete(int id) throws WorkingWithDBException {
        try {
            customerOrdersRepository.delete(id);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }
}
