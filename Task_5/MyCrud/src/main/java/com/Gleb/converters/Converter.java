package com.Gleb.converters;

import com.Gleb.entities.Car;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface Converter<T> {

    default T convertFromJson(String string) {
        Object object;
        try {
            object = this.getValueFromJson(string);
        } catch (JsonProcessingException e) {
            return null;
        }

        return (T) object;
    }

    default String convertToJson(Object object) {
        String jsonClient;
        try {
            jsonClient = this.getJsonFromObject(object);
        } catch (JsonProcessingException e) {
            return null;
        }

        return jsonClient;
    }

    Object getValueFromJson(String string) throws JsonProcessingException;

    String getJsonFromObject(Object object) throws JsonProcessingException;
}
