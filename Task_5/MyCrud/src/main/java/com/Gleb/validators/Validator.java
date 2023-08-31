package com.Gleb.validators;

import com.Gleb.entities.Client;
import com.Gleb.entities.CustomerOrder;

import java.sql.Date;

public interface Validator {

    default boolean validateId(int id) {
        if (id < 0) { return false; }

        return true;
    }

    default boolean validateForAdd(Object entity) {
        try {
            this.validateAddParam(entity);
        } catch ( Exception e) {
            return false; // тут добавить выброс своего исключения и сделать войд
        }

        return true;
    }

    default boolean validateForUpdate(Object entity) {
        try {
            this.validateUpdateParam(entity);
        } catch ( Exception e) {
            return false;
        }

        return true;
    }
    void validateAddParam(Object entity) throws Exception;

    void validateUpdateParam(Object entity) throws Exception;
}
