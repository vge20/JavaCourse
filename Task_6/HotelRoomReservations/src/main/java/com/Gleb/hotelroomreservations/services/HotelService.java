package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService implements BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel getById(int id) throws WorkingWithDBException {
        Hotel hotel;
        if ((hotel = this.hotelRepository.findHotelById(id)) == null) { throw new WorkingWithDBException(); }
        return hotel;
    }

    public void deleteById(int id) throws WorkingWithDBException {
        if (!this.hotelRepository.deleteHotelById(id)) { throw new WorkingWithDBException(); }
    }
}
