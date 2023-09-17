package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.Room;
import com.Gleb.hotelroomreservations.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
