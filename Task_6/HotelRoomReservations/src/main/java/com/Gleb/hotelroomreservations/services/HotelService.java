package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel getHotelById(int id) throws WorkingWithDBException {
        return this.getObject(hotelRepository, id);
    }

    public void addHotel(Hotel hotel) {

    }
}
