package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.ConditionsForReserve;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.models.OptionForReserve;
import com.Gleb.hotelroomreservations.services.HotelService;
import com.Gleb.hotelroomreservations.validators.HotelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/hotel/{id}")
    protected ResponseEntity<Object> doGet(@PathVariable int id) {
        return this.getObjectById(hotelValidator, hotelService, id);
    }

    @DeleteMapping("/hotel/{id}")
    protected ResponseEntity<Object> doDelete(@PathVariable int id) {
        return this.deleteObjectById(hotelValidator, hotelService, id);
    }

    @PostMapping("/hotel")
    protected ResponseEntity<Object> doPost(@RequestBody Hotel hotel) {
        return this.saveObject(hotelValidator, hotelService, hotel, true);
    }

    @PutMapping("/hotel")
    protected ResponseEntity<Object> doPut(@RequestBody Hotel hotel) {
        return this.saveObject(hotelValidator, hotelService, hotel, false);
    }

    @GetMapping("/hotel/reserveRoom/{userId}")
    protected String doGet(Model model, @RequestParam Date startDate, @PathVariable int userId,
                           @RequestParam Date endDate, @RequestParam String location) {
        List<OptionForReserve> optionsForReserve;
        ConditionsForReserve conditionsForReserve = new ConditionsForReserve(location, startDate, endDate);
        try {
            hotelValidator.validateConditionsForReserve(conditionsForReserve);
            optionsForReserve = this.hotelService.getDataForReserve(conditionsForReserve);
        } catch (WorkingWithDBException e) {
            return e.getJsonMessage();
        } catch (ValidationException e) {
            return e.getJsonMessage();
        }
        model.addAttribute("optionsForReserve", optionsForReserve);
        model.addAttribute("userId", userId);
        return "optionsForReserve";
    }
}
