package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController extends BaseController<Hotel> {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel/{id}")
    protected Object doGet(@PathVariable int id) {
        return this.getObjectById(hotelService, id);
    }

    @DeleteMapping("/hotel/{id}")
    protected Object doDelete(@PathVariable int id) { return this.deleteObjectById(hotelService, id); }
}
