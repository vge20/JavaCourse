package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.BaseException;
import com.Gleb.hotelroomreservations.models.Hotel;
import com.Gleb.hotelroomreservations.models.Room;
import com.Gleb.hotelroomreservations.services.RoomService;
import com.Gleb.hotelroomreservations.validators.RoomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController extends BaseController<Room> {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomValidator roomValidator;

    @GetMapping("/room/{id}")
    protected ResponseEntity<Object> doGet(@PathVariable int id) {
        return this.getObjectById(roomValidator, roomService, id);
    }

    @DeleteMapping("/room/{id}")
    protected ResponseEntity<Object> doDelete(@PathVariable int id) {
        return this.deleteObjectById(roomValidator, roomService, id);
    }

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

    @PutMapping("/room")
    protected ResponseEntity<Object> doPut(@RequestBody Room room) {
        return this.saveObject(roomValidator, roomService, room, false);
    }
}
