package com.Gleb.validators;

import com.Gleb.entities.Car;
import com.Gleb.entities.CustomerOrder;

import java.sql.Date;

public class CustomerOrdersValidator implements Validator {

    @Override
    public void validateAddParam(Object entity) throws Exception {
        CustomerOrder customerOrder = (CustomerOrder) entity;
        if (customerOrder.getClientId() < 0) { throw new Exception(); }
        if (customerOrder.getCarId() < 0) { throw new Exception(); }
        Date.valueOf(customerOrder.getOrderDate()); // проверка ввода из json
    }

    @Override
    public void validateUpdateParam(Object entity) throws Exception {
        CustomerOrder customerOrder = (CustomerOrder) entity;
        if (customerOrder.getId() < 0) { throw new Exception(); }
        if (customerOrder.getClientId() < 0) { throw new Exception(); }
        if (customerOrder.getCarId() < 0) { throw new Exception(); }
        Date.valueOf(customerOrder.getOrderDate()); // проверка ввода из json
    }
}
