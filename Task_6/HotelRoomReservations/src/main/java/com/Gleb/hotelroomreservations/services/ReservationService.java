package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.Reservation;
import com.Gleb.hotelroomreservations.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements BaseService<Reservation> {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation getByIdImpl(int id) {
        return this.reservationRepository.findReservationById(id);
    }

    @Override
    public boolean deleteByIdImpl(int id) {
        return this.reservationRepository.deleteReservationById(id);
    }

    @Override
    public Reservation saveObjectImpl(Object object) {
        return this.reservationRepository.save((Reservation) object);
    }
}
