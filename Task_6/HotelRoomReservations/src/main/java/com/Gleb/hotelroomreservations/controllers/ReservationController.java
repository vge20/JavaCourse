package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.Reservation;
import com.Gleb.hotelroomreservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController extends BaseController<Reservation> {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation/{id}")
    protected Object doGet(@PathVariable int id) {
        return this.getObjectById(reservationService, id);
    }

    @DeleteMapping("/reservation/{id}")
    protected Object doDelete(@PathVariable int id) {
        return this.deleteObjectById(reservationService, id);
    }
}
