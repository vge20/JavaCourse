package com.Gleb.services;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.CustomerOrdersRepository;

import java.sql.SQLException;

public class CustomerOrdersService {

    private CustomerOrdersRepository customerOrdersRepository;

    public CustomerOrdersService() {
        customerOrdersRepository = new CustomerOrdersRepository();
    }

    public CustomerOrder getCustomerOrder(int id) throws Exception {
        return customerOrdersRepository.getCustomerOrderById(id);
    }

    public void addCustomerOrder(CustomerOrder customerOrder) throws SQLException {
        customerOrdersRepository.addCustomerOrder(customerOrder);
    }

    public void updateCustomerOrder(CustomerOrder customerOrder) throws SQLException {
        customerOrdersRepository.updateCustomerOrder(customerOrder);
    }

    public void deleteCustomerOrder(int id) throws SQLException {
        customerOrdersRepository.deleteCustomerOrder(id);
    }
}
