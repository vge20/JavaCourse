package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.*;
import com.Gleb.hotelroomreservations.models.AuthenticateParameters;
import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.services.UserService;
import com.Gleb.hotelroomreservations.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@Controller
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping("/user/authenticate")
    protected String doPost(@RequestParam String login, @RequestParam String password, Model model) {
        User user;
        try {
            AuthenticateParameters authenticateParameters = new AuthenticateParameters(login, password);
            userValidator.validateAuthenticateParameters(authenticateParameters);
            authenticateParameters.setPassword(Base64.getEncoder().encodeToString
                    (authenticateParameters.getPassword().getBytes()));
            user = userService.authentication(authenticateParameters);
        } catch (BaseException e) {
            return e.getTemplate();
        }

        model.addAttribute("userId", user.getId());

        if (user.isAdmin())
            return "redirect:/hotel";
        else
            return "userMenu";
    }

    @GetMapping("/")
    protected String doGet() {
        return "login";
    }
}
