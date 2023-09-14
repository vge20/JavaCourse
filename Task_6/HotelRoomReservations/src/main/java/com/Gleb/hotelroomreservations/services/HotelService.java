package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.repositories.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelsService {

    @Autowired
    private HotelsRepository hotelsRepository;

    public Hotel getHotelById(Integer id) {
        return this.hotelsRepository.findHotelById(id);
    }
}
