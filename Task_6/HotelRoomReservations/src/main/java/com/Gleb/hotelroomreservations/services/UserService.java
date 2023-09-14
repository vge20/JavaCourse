package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int id) {
        return this.userRepository.findUserById(id);
    }
}
