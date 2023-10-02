package com.Gleb.hotelroomreservations.validators;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.models.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomValidator implements Validator {

    @Override
    public void validateAddParam(Object object) throws Exception {
        Room room = (Room) object;
        if (room.getHotelId() < 0) throw new ValidationException();
    }

    @Override
    public void validateUpdateParam(Object object) throws Exception {
        Room room = (Room) object;
        if (room.getId() < 0) throw new ValidationException();
        if (room.getHotelId() < 0) throw new ValidationException();
    }
}
