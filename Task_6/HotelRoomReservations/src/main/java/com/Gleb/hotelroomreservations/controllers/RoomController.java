package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.Room;
import com.Gleb.hotelroomreservations.services.RoomService;
import com.Gleb.hotelroomreservations.validators.RoomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController extends BaseController<Room> {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomValidator roomValidator;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/room")
    protected String doPost(@RequestParam int hotelId) {
        return this.addObject(roomValidator, roomService, new Room(hotelId), "redirect:/hotel");
    }
}
