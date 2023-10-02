package com.Gleb.hotelroomreservations.validators;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.models.User;

public class UserValidator implements Validator {

    @Override
    public void validateAddParam(Object entity) throws Exception {
        User user = (User) entity;
        user.isAdmin();
        if (user.getPassw() == null) throw new ValidationException();
        if (user.getLogin() == null) throw new ValidationException();
    }

    @Override
    public void validateUpdateParam(Object entity) throws Exception {
        User user = (User) entity;
        if (user.getId() < 0) throw new ValidationException();
        user.isAdmin();
        if (user.getPassw() == null) throw new ValidationException();
        if (user.getLogin() == null) throw new ValidationException();
    }
}
