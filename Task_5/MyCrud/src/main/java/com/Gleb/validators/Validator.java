package com.Gleb.validators;

public interface Validator {

    default boolean validateId(int id) {
        if (id < 0) { return false; }

        return true;
    }

}
