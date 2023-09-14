package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel")
    protected Object doGet() {
        return hotelService.getHotelById(1);
    }
}
