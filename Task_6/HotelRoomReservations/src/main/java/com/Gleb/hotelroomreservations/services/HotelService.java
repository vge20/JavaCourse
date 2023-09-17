package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService implements BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel getByIdImpl(int id) {
        return this.hotelRepository.findHotelById(id);
    }

    public boolean deleteByIdImpl(int id) {
        return this.hotelRepository.deleteHotelById(id);
    }
}
