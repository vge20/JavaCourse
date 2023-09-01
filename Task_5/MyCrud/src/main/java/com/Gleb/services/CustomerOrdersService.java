package com.Gleb.services;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.CustomerOrdersRepository;
import com.Gleb.repositories.Repository;

import java.sql.SQLException;

public class CustomerOrdersService {

    private Repository<CustomerOrder> customerOrdersRepository;

    public CustomerOrdersService() {
        customerOrdersRepository = new CustomerOrdersRepository();
    }

    public CustomerOrder getCustomerOrder(int id) throws Exception {
        return customerOrdersRepository.getById(id);
    }

    public void addCustomerOrder(CustomerOrder customerOrder) throws SQLException {
        customerOrdersRepository.add(customerOrder);
    }

    public void updateCustomerOrder(CustomerOrder customerOrder) throws SQLException {
        customerOrdersRepository.update(customerOrder);
    }

    public void deleteCustomerOrder(int id) throws SQLException {
        customerOrdersRepository.delete(id);
    }
}
