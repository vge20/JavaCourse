package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.AuthenticationException;
import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.User;
import com.Gleb.hotelroomreservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

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
    public void deleteByIdImpl(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User saveObjectImpl(Object object) {
        User user = (User) object;
        user.setPassw(Base64.getEncoder().encodeToString(user.getPassw().getBytes()));
        return userRepository.save(user);
    }

    public User getUserByLogin(String login) throws AuthenticationException, WorkingWithDBException {
        User user = null;
        try {
            user = userRepository.findUserByLogin(login);
        } catch (Exception e) {
            throw new WorkingWithDBException();
        }
        if (user == null) throw new AuthenticationException();

        return user;
    }
}
