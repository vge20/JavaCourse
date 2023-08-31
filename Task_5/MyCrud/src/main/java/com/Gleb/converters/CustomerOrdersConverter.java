package com.Gleb.converters;

import com.Gleb.entities.Car;
import com.Gleb.entities.Client;
import com.Gleb.entities.CustomerOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerOrdersConverter implements Converter{

    ObjectMapper objectMapper;

    public CustomerOrdersConverter() {
        this.objectMapper = new ObjectMapper();
    }


    @Override
    public Object getValueFromJson(String string) throws JsonProcessingException {
        return objectMapper.readValue(string, CustomerOrder.class);
    }

    @Override
    public String getJsonFromObject(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString((CustomerOrder) object);
    }
}
