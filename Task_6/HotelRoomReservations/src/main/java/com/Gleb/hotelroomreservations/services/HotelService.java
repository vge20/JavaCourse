package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelService implements BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;

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
}
