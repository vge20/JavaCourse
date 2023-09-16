package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
