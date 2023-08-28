package com.Gleb.validators;

import com.Gleb.entities.Car;
import com.Gleb.entities.CustomerOrder;

import java.sql.Date;

public class CustomerOrdersValidator implements Validator {

    public boolean validateForAdd(CustomerOrder customerOrder) {
        try {
            if (customerOrder.getClientId() < 0) { throw new Exception(); }
            if (customerOrder.getCarId() < 0) { throw new Exception(); }
            Date.valueOf(customerOrder.getOrderDate()); // проверка ввода из json
        } catch ( Exception e) {
            return false;
        }

        return true;
    }

    public boolean validateForUpdate(CustomerOrder customerOrder) {
        try {
            if (customerOrder.getId() < 0) { throw new Exception(); }
            if (customerOrder.getClientId() < 0) { throw new Exception(); }
            if (customerOrder.getCarId() < 0) { throw new Exception(); }
            Date.valueOf(customerOrder.getOrderDate()); // проверка ввода из json
        } catch ( Exception e) {
            return false;
        }

        return true;
    }
}
