package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    protected Object doGet(@PathVariable int id) {
        return this.getObjectById(userService, id);
    }

    @DeleteMapping("/user/{id}")
    protected Object doDelete(@PathVariable int id) {
        return this.deleteObjectById(userService, id);
    }

    @PostMapping("/user")
    protected ResponseEntity<Object> doPost(@RequestBody User user) {
        return this.saveObject(userService, user);
    }

    @PutMapping("/user")
    protected ResponseEntity<Object> doPut(@RequestBody User user) {
        return this.saveObject(userService, user);
    }
}
