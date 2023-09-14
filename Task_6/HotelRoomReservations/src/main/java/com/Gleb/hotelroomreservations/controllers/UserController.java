package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    protected Object doGet() {
        return this.userService.getUserById(1);
    }
}
