package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.ConditionsForReserve;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.models.OptionForReserve;
import com.Gleb.hotelroomreservations.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController extends BaseController<Hotel> {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel/{id}")
    protected ResponseEntity<Object> doGet(@PathVariable int id) {
        return this.getObjectById(hotelService, id);
    }

    @DeleteMapping("/hotel/{id}")
    protected ResponseEntity<Object> doDelete(@PathVariable int id) { return this.deleteObjectById(hotelService, id); }

    @PostMapping("/hotel")
    protected ResponseEntity<Object> doPost(@RequestBody Hotel hotel) {
        return this.saveObject(hotelService, hotel);
    }

    @PutMapping("/hotel")
    protected ResponseEntity<Object> doPut(@RequestBody Hotel hotel) {
        return this.saveObject(hotelService, hotel);
    }

    @GetMapping("/hotel/reserveRoom")
    protected ResponseEntity<Object> doGet(@RequestBody ConditionsForReserve conditionsForReserve) {
        List<OptionForReserve> optionsForReserves;
        try {
            optionsForReserves = this.hotelService.getDataForReserve(conditionsForReserve);
        } catch (WorkingWithDBException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(optionsForReserves, HttpStatus.OK);
    }
}
