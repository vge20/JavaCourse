package com.Gleb.converters;

import com.Gleb.entities.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientsConverter implements Converter{

    ObjectMapper objectMapper;

    public ClientsConverter() {
        objectMapper = new ObjectMapper();
    }


    @Override
    public Object getValueFromJson(String string) throws JsonProcessingException {
        return objectMapper.readValue(string, Client.class);
    }

    @Override
    public String getJsonFromObject(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString((Client) object);
    }
}
