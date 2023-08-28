package com.Gleb.converters;

import com.Gleb.entities.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarsConverter {

    ObjectMapper objectMapper;

    public CarsConverter() {
        objectMapper = new ObjectMapper();
    }

    public Car convertFromJson(String string) {
        Car car;
        try {
            car = objectMapper.readValue(string, Car.class);
        } catch (JsonProcessingException e) {
            return null;
        }

        return car;
    }

    public String convertToJson(Car car) {
        String jsonClient;
        try {
            jsonClient = objectMapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            return null;
        }

        return jsonClient;
    }
}
