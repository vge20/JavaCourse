package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.services.UserService;
import com.Gleb.hotelroomreservations.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/user/{id}")
    protected ResponseEntity<Object> doGet(@PathVariable int id) {
        return this.getObjectById(userValidator, userService, id);
    }

    @DeleteMapping("/user/{id}")
    protected ResponseEntity<Object> doDelete(@PathVariable int id) {
        return this.deleteObjectById(userValidator, userService, id);
    }

    @PostMapping("/user")
    protected ResponseEntity<Object> doPost(@RequestBody User user) {
        return this.saveObject(userValidator, userService, user, true);
    }

    @PutMapping("/user")
    protected ResponseEntity<Object> doPut(@RequestBody User user) {
        return this.saveObject(userValidator, userService, user, false);
    }
}
