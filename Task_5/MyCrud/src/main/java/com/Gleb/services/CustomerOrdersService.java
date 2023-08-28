package com.Gleb.services;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.CustomerOrdersRepository;

public class CustomerOrdersService {

    private CustomerOrdersRepository customerOrdersRepository;

    public CustomerOrdersService() {
        customerOrdersRepository = new CustomerOrdersRepository();
    }

    public CustomerOrder getCustomerOrder(int id) {
        CustomerOrder customerOrder;
        try {
            customerOrder = customerOrdersRepository.getCustomerOrderById(id);
        } catch (Exception e) {
            return null;
        }

        return customerOrder;
    }

    public boolean addCustomerOrder(CustomerOrder customerOrder) {
        try {
            customerOrdersRepository.addCustomerOrder(customerOrder);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean updateCustomerOrder(CustomerOrder customerOrder) {
        try {
            customerOrdersRepository.updateCustomerOrder(customerOrder);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean deleteCustomerOrder(int id) {
        try {
            customerOrdersRepository.deleteCustomerOrder(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
