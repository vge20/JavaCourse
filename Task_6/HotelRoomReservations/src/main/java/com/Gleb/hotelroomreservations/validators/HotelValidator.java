package com.Gleb.hotelroomreservations.validators;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.models.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelValidator implements Validator {

    @Override
    public void validateAddParam(Object object) throws Exception {
        Hotel hotel = (Hotel) object;
        if (hotel.getLocation() == null) throw new ValidationException();
    }

    @Override
    public void validateUpdateParam(Object object) throws Exception {
        Hotel hotel = (Hotel) object;
        if (hotel.getId() < 0) throw new ValidationException();
        if (hotel.getLocation() == null) throw new ValidationException();
    }
}
