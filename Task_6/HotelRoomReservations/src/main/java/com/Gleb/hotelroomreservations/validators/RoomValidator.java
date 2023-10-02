package com.Gleb.hotelroomreservations.validators;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.models.Room;

public class RoomValidator implements Validator {

    @Override
    public void validateAddParam(Object entity) throws Exception {
        Room room = (Room) entity;
        if (room.getHotelId() < 0) throw new ValidationException();
    }

    @Override
    public void validateUpdateParam(Object entity) throws Exception {
        Room room = (Room) entity;
        if (room.getId() < 0) throw new ValidationException();
        if (room.getHotelId() < 0) throw new ValidationException();
    }
}
