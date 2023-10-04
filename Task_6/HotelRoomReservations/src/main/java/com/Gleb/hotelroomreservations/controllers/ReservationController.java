package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.BaseException;
import com.Gleb.hotelroomreservations.models.Reservation;
import com.Gleb.hotelroomreservations.services.ReservationService;
import com.Gleb.hotelroomreservations.validators.ReservationValidator;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/reservation/{userId}")
    protected String doPost(@RequestParam Date startDate, @RequestParam Date endDate,
                            @RequestParam int hotelId, @RequestParam int roomId,
                            @PathVariable int userId, Model model) {
        Reservation reservation = new Reservation(hotelId, roomId, userId, startDate, endDate);
        try {
            reservationValidator.validateForAdd(reservation);
            reservationService.saveObject(reservation);
        } catch (BaseException e) {
            return e.getTemplate();
        }
        model.addAttribute("userId", userId);
        return "userMenu";
    }

    @PostMapping("/reservation/delete/{userId}")
    protected String doPost(@RequestParam int hotelId, @RequestParam int roomId,
                            @RequestParam Date startDateForDel, @RequestParam Date endDateForDel,
                            @PathVariable int userId, Model model) {
        Reservation reservation = new Reservation(hotelId, roomId, userId, startDateForDel, endDateForDel);
        try {
            reservationValidator.validateForUpdate(reservation);
            reservationService.deleteReservation(reservation);
        } catch (BaseException e) {
            return e.getTemplate();
        }
        model.addAttribute("userId", userId);
        return "userMenu";
    }
}
