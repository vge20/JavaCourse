package com.Gleb.hotelroomreservations.validators;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator {

    @Override
    public void validateAddParam(Object object) throws Exception {
        User user = (User) object;
        user.isAdmin();
        if (user.getPassw() == null) throw new ValidationException();
        if (user.getLogin() == null) throw new ValidationException();
    }

    @Override
    public void validateUpdateParam(Object object) throws Exception {
        User user = (User) object;
        if (user.getId() < 0) throw new ValidationException();
        user.isAdmin();
        if (user.getPassw() == null) throw new ValidationException();
        if (user.getLogin() == null) throw new ValidationException();
    }
}
