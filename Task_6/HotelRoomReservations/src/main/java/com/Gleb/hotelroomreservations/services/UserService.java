package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int id) throws WorkingWithDBException {
        return this.userRepository.findUserById(id);
    }
}
