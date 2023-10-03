package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.Reservation;
import com.Gleb.hotelroomreservations.services.ReservationService;
import com.Gleb.hotelroomreservations.validators.ReservationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
public class ReservationController extends BaseController<Reservation> {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationValidator reservationValidator;

    @GetMapping("/reservation/{id}")
    protected ResponseEntity<Object> doGet(@PathVariable int id) {
        return this.getObjectById(reservationValidator, reservationService, id);
    }

    @DeleteMapping("/reservation/{id}")
    protected ResponseEntity<Object> doDelete(@PathVariable int id) {
        return this.deleteObjectById(reservationValidator, reservationService, id);
    }

    @PostMapping("/reservation/{userId}")
    protected ResponseEntity<Object> doPost(@RequestParam Date startDate, @RequestParam Date endDate,
                                            @RequestParam int hotelId, @RequestParam int roomId,
                                            @PathVariable int userId) {
        Reservation reservation = new Reservation(hotelId, roomId, userId, startDate, endDate);
        return this.saveObject(reservationValidator, reservationService, reservation, true);
    }

    @PutMapping("/reservation")
    protected ResponseEntity<Object> doPut(@RequestBody Reservation reservation) {
        return this.saveObject(reservationValidator, reservationService, reservation, false);
    }
}
