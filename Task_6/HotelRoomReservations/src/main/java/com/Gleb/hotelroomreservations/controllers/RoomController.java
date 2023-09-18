package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.Room;
import com.Gleb.hotelroomreservations.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController extends BaseController<Room> {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room/{id}")
    protected Object doGet(@PathVariable int id) {
        return this.getObjectById(roomService, id);
    }

    @DeleteMapping("/room/{id}")
    protected Object doDelete(@PathVariable int id) {
        return this.deleteObjectById(roomService, id);
    }

    @PostMapping(value = "/room")
    protected ResponseEntity<Object> doPost(@RequestBody Room room) {
        return this.saveObject(roomService, room);
    }

    @PutMapping("/room")
    protected ResponseEntity<Object> doPut(@RequestBody Room room) {
        return this.saveObject(roomService, room);
    }
}
