package com.Gleb.validators;

import com.Gleb.entities.Client;

import java.sql.Date;

public class ClientsValidator implements Validator {

    @Override
    public void validateAddParam(Object entity) throws Exception {
        Client client = (Client) entity;
        client.getFullName();  // проверка, что нужные параметры переданы в json
        client.isGender();    // если их не передано, то будет Exception
        Date.valueOf(client.getDateBirth()); // проверка валидности даты в json
    }

    @Override
    public void validateUpdateParam(Object entity) throws Exception {
        Client client = (Client) entity;
        if (client.getId() < 0) { throw new Exception(); }
        client.getFullName(); // проверка, что все нужные параметры были переданы,
        client.isGender();   // а также их валидности
        Date.valueOf(client.getDateBirth());
    }
}
