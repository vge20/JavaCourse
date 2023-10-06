package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.*;
import com.Gleb.hotelroomreservations.models.AuthenticateParameters;
import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.services.UserService;
import com.Gleb.hotelroomreservations.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    /*@PostMapping("/user/authenticate")
    protected String doPost(@RequestParam String username, @RequestParam String password, Model model) {
        System.out.println("AAA");
        User user;
        try {
            AuthenticateParameters authenticateParameters = new AuthenticateParameters(username, password);
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
    }*/

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    protected String doGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return "adminMenu";
        }
        else
            return "userMenu";
    }
}
