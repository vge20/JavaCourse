package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.Reservation;
import com.Gleb.hotelroomreservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/reservation")
    protected ResponseEntity<Object> doPost(@RequestBody Reservation reservation) {
        return this.saveObject(reservationService, reservation);
    }

    @PutMapping("/reservation")
    protected ResponseEntity<Object> doPut(@RequestBody Reservation reservation) {
        return this.saveObject(reservationService, reservation);
    }
}
