package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.Reservation;
import com.Gleb.hotelroomreservations.services.ReservationService;
import com.Gleb.hotelroomreservations.validators.ReservationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class ReservationController extends BaseController<Reservation> {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationValidator reservationValidator;

    @GetMapping("/reservation/{id}")
    protected ResponseEntity<Object> doGet(@PathVariable int id) {
        return this.getObjectById(reservationValidator, reservationService, id);
    }

    @DeleteMapping("/reservation/{userId}")
    protected String doDelete(@RequestParam int hotelId, @RequestParam int roomId,
                              @RequestParam Date startDateForDel, @RequestParam Date endDateForDel,
                              @PathVariable int userId, Model model) {
        Reservation reservation = new Reservation(hotelId, roomId, userId, startDateForDel, endDateForDel);
        try {
            reservationValidator.validateForUpdate(reservation);
            reservationService.deleteReservation(reservation);
        } catch (WorkingWithDBException e) {
            return e.getJsonMessage();
        } catch (ValidationException e) {
            return e.getJsonMessage();
        }
        model.addAttribute("userId", userId);
        return "inputConditionsForReserve";
    }

    @PostMapping("/reservation/{userId}")
    protected String doPost(@RequestParam Date startDate, @RequestParam Date endDate,
                                            @RequestParam int hotelId, @RequestParam int roomId,
                                            @PathVariable int userId) {
        Reservation reservation = new Reservation(hotelId, roomId, userId, startDate, endDate);
        try {
            reservationValidator.validateForAdd(reservation);
            reservationService.saveObject(reservation);
        } catch (WorkingWithDBException e) {
            return e.getJsonMessage();
        } catch (ValidationException e) {
            return e.getJsonMessage();
        }
        return "login";
    }

    @PutMapping("/reservation")
    protected ResponseEntity<Object> doPut(@RequestBody Reservation reservation) {
        return this.saveObject(reservationValidator, reservationService, reservation, false);
    }
}
