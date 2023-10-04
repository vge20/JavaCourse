package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.BaseException;
import com.Gleb.hotelroomreservations.models.Room;
import com.Gleb.hotelroomreservations.services.RoomService;
import com.Gleb.hotelroomreservations.validators.RoomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController extends BaseController<Room> {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomValidator roomValidator;

    @PostMapping(value = "/room")
    protected String doPost(@RequestParam int hotelId) {
        Room room = new Room(hotelId);
        try {
            roomValidator.validateForAdd(room);
            roomService.saveObject(room);
        } catch (BaseException e) {
            return e.getTemplate();
        }
        return "redirect:/hotel";
    }
}
