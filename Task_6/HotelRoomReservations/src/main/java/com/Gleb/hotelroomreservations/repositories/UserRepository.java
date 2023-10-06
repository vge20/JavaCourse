package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById(int id);

    User findUserByLogin(String login);

    @Query("select * from public.user")
    List<User> getUsersList();
}
