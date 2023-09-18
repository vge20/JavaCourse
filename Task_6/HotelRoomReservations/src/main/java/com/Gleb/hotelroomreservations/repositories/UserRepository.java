package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById(int id);

    User deleteUserById(int id);
}
