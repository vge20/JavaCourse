package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    public User getByIdImpl(int id) {
        return this.userRepository.findUserById(id);
    }

    public boolean deleteByIdImpl(int id) {
        return this.userRepository.deleteUserById(id);
    }
}
