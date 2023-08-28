package com.Gleb.converters;

import com.Gleb.entities.Car;
import com.Gleb.entities.CustomerOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerOrdersConverter {

    ObjectMapper objectMapper;

    public CustomerOrdersConverter() {
        this.objectMapper = new ObjectMapper();
    }

    public CustomerOrder convertFromJson(String string) {
        CustomerOrder customerOrder;
        try {
            customerOrder = objectMapper.readValue(string, CustomerOrder.class);
        } catch (JsonProcessingException e) {
            return null;
        }

        return customerOrder;
    }

    public String convertToJson(CustomerOrder customerOrder) {
        String jsonClient;
        try {
            jsonClient = objectMapper.writeValueAsString(customerOrder);
        } catch (JsonProcessingException e) {
            return null;
        }

        return jsonClient;
    }
}
