package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByIdImpl(int id) {
        return this.userRepository.findUserById(id);
    }

    @Override
    @Transactional
    public boolean deleteByIdImpl(int id) {
        return this.userRepository.deleteUserById(id);
    }

    @Override
    @Transactional
    public User saveObjectImpl(Object object) {
        return userRepository.save((User) object);
    }
}
