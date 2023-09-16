package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    public User getById(int id) throws WorkingWithDBException {
        User user;
        if ((user = this.userRepository.findUserById(id)) == null) { throw new WorkingWithDBException(); }
        return user;
    }

    public void deleteById(int id) throws WorkingWithDBException {
        if (!this.userRepository.deleteUserById(id)) { throw new WorkingWithDBException(); }
    }
}
