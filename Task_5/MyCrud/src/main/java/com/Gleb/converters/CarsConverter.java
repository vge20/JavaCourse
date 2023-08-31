package com.Gleb.converters;

import com.Gleb.entities.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarsConverter implements Converter{

    ObjectMapper objectMapper;

    public CarsConverter() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public Object getValueFromJson(String string) throws JsonProcessingException {
        return objectMapper.readValue(string, Car.class);
    }

    @Override
    public String getJsonFromObject(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString((Car) object);
    }
}
