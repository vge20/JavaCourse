package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel/{id}")
    protected Object doGet(@PathVariable int id) {

        Hotel hotel;
        try {
            hotel = this.hotelService.getHotelById(id);
        }
        catch (WorkingWithDBException e) {
            return e;
        }

        return hotel;
    }
}
