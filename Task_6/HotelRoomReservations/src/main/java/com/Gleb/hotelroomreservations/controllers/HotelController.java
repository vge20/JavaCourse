package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.services.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelsController {

    @Autowired
    private HotelsService hotelsService;

    @GetMapping("/hotels")
    protected Object doGet() {
        return hotelsService.getHotelById(1);
    }
}
