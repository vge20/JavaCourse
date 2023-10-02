package com.Gleb.hotelroomreservations.validators;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.models.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationValidator implements Validator {

    @Override
    public void validateAddParam(Object object) throws Exception {
        Reservation reservation = (Reservation) object;
        if (reservation.getRoomId() < 0) throw new ValidationException();
        if (reservation.getUserId() < 0) throw new ValidationException();
        if (reservation.getStartDate() == null) throw new ValidationException();
        if (reservation.getEndDate() == null) throw new ValidationException();
    }

    @Override
    public void validateUpdateParam(Object object) throws Exception {
        Reservation reservation = (Reservation) object;
        if (reservation.getId() < 0) throw new ValidationException();
        if (reservation.getRoomId() < 0) throw new ValidationException();
        if (reservation.getUserId() < 0) throw new ValidationException();
        if (reservation.getStartDate() == null) throw new ValidationException();
        if (reservation.getEndDate() == null) throw new ValidationException();
    }
}
