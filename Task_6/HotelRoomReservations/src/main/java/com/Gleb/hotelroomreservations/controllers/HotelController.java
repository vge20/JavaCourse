package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.BaseException;
import com.Gleb.hotelroomreservations.models.ConditionsForReserve;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.models.OptionForReserve;
import com.Gleb.hotelroomreservations.services.HotelService;
import com.Gleb.hotelroomreservations.validators.HotelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class HotelController extends BaseController<Hotel> {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelValidator hotelValidator;

    @GetMapping("/hotel")
    protected String doGet(Model model) {
        List<Hotel> hotels;
        try {
            hotels = hotelService.getHotelsList();
        } catch (BaseException e) {
            return e.getTemplate();
        }
        model.addAttribute("hotels", hotels);
        return "adminMenu";
    }

    @PostMapping("/hotel")
    protected String doPost(@RequestParam String location) {
        return this.addObject(hotelValidator, hotelService, new Hotel(location), "redirect:/hotel");
    }

    @GetMapping("/hotel/reserveRoom/{userId}")
    protected String doGet(Model model, @RequestParam Date startDate, @PathVariable int userId,
                           @RequestParam Date endDate, @RequestParam String location) {
        List<OptionForReserve> optionsForReserve;
        ConditionsForReserve conditionsForReserve = new ConditionsForReserve(location, startDate, endDate);
        try {
            hotelValidator.validateConditionsForReserve(conditionsForReserve);
            optionsForReserve = this.hotelService.getDataForReserve(conditionsForReserve);
        } catch (BaseException e) {
            return e.getTemplate();
        }
        model.addAttribute("optionsForReserve", optionsForReserve);
        model.addAttribute("userId", userId);
        return "reservation";
    }
}
