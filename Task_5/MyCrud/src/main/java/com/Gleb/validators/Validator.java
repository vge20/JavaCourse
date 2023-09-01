package com.Gleb.validators;

import com.Gleb.entities.Client;
import com.Gleb.entities.CustomerOrder;
import com.Gleb.exceptions.ValidationException;

import java.sql.Date;

public interface Validator {

    default void validateId(int id) throws ValidationException {
        if (id < 0) {
            throw new ValidationException();
        }
    }

    default void validateForAdd(Object entity) throws ValidationException {
        try {
            this.validateAddParam(entity);
        } catch ( Exception e) {
            throw new ValidationException();
        }
    }

    default void validateForUpdate(Object entity) throws ValidationException {
        try {
            this.validateUpdateParam(entity);
        } catch ( Exception e) {
            throw new ValidationException();
        }
    }
    void validateAddParam(Object entity) throws Exception;

    void validateUpdateParam(Object entity) throws Exception;
}
