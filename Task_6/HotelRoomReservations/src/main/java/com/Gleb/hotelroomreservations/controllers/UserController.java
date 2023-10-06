package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.BaseException;
import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    protected String doGet(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/hotel";
        }
        else {
            User user;
            try {
                user = userService.getUserByLogin(auth.getName());
            } catch (BaseException e) {
                return e.getTemplate();
            }

            model.addAttribute("userId", user.getId());

            return "userMenu";
        }
    }
}
