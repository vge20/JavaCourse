package com.Gleb.converters;

import com.Gleb.exceptions.ConversionException;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface Converter<T> {

    default T convertFromJson(String string) throws ConversionException {
        Object object;
        try {
            object = this.getValueFromJson(string);
        } catch (JsonProcessingException e) {
            throw new ConversionException();
        }

        return (T) object;
    }

    default String convertToJson(Object object) throws ConversionException {
        String jsonClient;
        try {
            jsonClient = this.getJsonFromObject(object);
        } catch (JsonProcessingException e) {
            throw new ConversionException();
        }

        return jsonClient;
    }

    Object getValueFromJson(String string) throws JsonProcessingException;

    String getJsonFromObject(Object object) throws JsonProcessingException;
}
