package com.Gleb.converters;

import com.Gleb.entities.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientsConverter {

    ObjectMapper objectMapper;

    public ClientsConverter() {
        objectMapper = new ObjectMapper();
    }

    public Client convertFromJson(String string) {
        Client client;
        try {
            client = objectMapper.readValue(string, Client.class);
        } catch (JsonProcessingException e) {
            return null;
        }

        return client;
    }

    public String convertToJson(Client client) {
        String jsonClient;
        try {
            jsonClient = objectMapper.writeValueAsString(client);
        } catch (JsonProcessingException e) {
            return null;
        }

        return jsonClient;
    }
}
