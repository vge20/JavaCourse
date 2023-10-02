package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.ConditionsForReserve;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.models.OptionForReserve;
import com.Gleb.hotelroomreservations.services.HotelService;
import com.Gleb.hotelroomreservations.validators.HotelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/hotel/reserveRoom")
    protected ResponseEntity<Object> doGet(@RequestBody ConditionsForReserve conditionsForReserve) {
        List<OptionForReserve> optionsForReserves;
        try {
            hotelValidator.validateConditionsForReserve(conditionsForReserve);
            optionsForReserves = this.hotelService.getDataForReserve(conditionsForReserve);
        } catch (WorkingWithDBException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(optionsForReserves, HttpStatus.OK);
    }
}
