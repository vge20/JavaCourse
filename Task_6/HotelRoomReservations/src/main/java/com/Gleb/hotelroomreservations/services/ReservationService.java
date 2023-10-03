package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.NotFoundException;
import com.Gleb.hotelroomreservations.models.Reservation;
import com.Gleb.hotelroomreservations.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService implements BaseService<Reservation> {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation getByIdImpl(int id) {
        return this.reservationRepository.findReservationById(id);
    }

    @Override
    @Transactional
    public void deleteByIdImpl(int id) {
        this.reservationRepository.deleteById(id);
    }

    @Transactional
    public void deleteReservation(Reservation reservation) throws NotFoundException {
        try {
            this.reservationRepository.delete(reservation);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    @Transactional
    public Reservation saveObjectImpl(Object object) {
        return this.reservationRepository.save((Reservation) object);
    }
}
