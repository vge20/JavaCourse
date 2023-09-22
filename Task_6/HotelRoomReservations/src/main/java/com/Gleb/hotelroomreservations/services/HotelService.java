package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.ConditionsForReserve;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.models.OptionsForReserve;
import com.Gleb.hotelroomreservations.repositories.HotelRepository;
import com.Gleb.hotelroomreservations.repositories.ReservationRepository;
import com.Gleb.hotelroomreservations.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelService implements BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Hotel getByIdImpl(int id) {
        return this.hotelRepository.findHotelById(id);
    }

    @Override
    @Transactional
    public void deleteByIdImpl(int id) {
        this.hotelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Hotel saveObjectImpl(Object object) {
        return this.hotelRepository.save((Hotel) object);
    }

    @Transactional
    public List<OptionsForReserve> getDataForReserve(ConditionsForReserve conditionsForReserve)
            throws WorkingWithDBException {
        
    }
}
