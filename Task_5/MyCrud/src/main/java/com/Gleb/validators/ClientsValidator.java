package com.Gleb.validators;

import com.Gleb.entities.Client;

import java.sql.Date;

public class ClientsValidator implements Validator {

    public boolean validateForAdd(Client client) {
        try {
            client.getFullName();  // проверка, что нужные параметры переданы в json
            client.getGender();    // если их не передано, то будет Exception
            Date.valueOf(client.getDateBirth()); // проверка валидности даты в json
        } catch ( Exception e) {
            return false;
        }

        return true;
    }

    public boolean validateForUpdate(Client client) {
        try {
            if (client.getId() < 0) { throw new Exception(); }
            client.getFullName(); // проверка, что все нужные параметры были переданы,
            client.getGender();   // а также их валидности
            Date.valueOf(client.getDateBirth());
        } catch ( Exception e) {
            return false;
        }

        return true;
    }
}
