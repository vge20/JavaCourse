package com.Gleb.hotelroomreservations.validators;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.models.Hotel;

public class HotelValidator implements Validator {

    @Override
    public void validateAddParam(Object entity) throws Exception {
        Hotel hotel = (Hotel) entity;
        if (hotel.getLocation() == null) throw new ValidationException();
    }

    @Override
    public void validateUpdateParam(Object entity) throws Exception {
        Hotel hotel = (Hotel) entity;
        if (hotel.getId() < 0) throw new ValidationException();
        if (hotel.getLocation() == null) throw new ValidationException();
    }
}
