package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.Room;
import com.Gleb.hotelroomreservations.services.RoomService;
import com.Gleb.hotelroomreservations.validators.RoomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
    protected ResponseEntity<Object> doPost(@RequestBody Room room) {
        return this.saveObject(roomValidator, roomService, room, true);
    }

    @PutMapping("/room")
    protected ResponseEntity<Object> doPut(@RequestBody Room room) {
        return this.saveObject(roomValidator, roomService, room, false);
    }
}
