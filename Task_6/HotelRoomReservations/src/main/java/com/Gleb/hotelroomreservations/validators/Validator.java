package com.Gleb.hotelroomreservations.validators;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;

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
