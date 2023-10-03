package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById(int id);

    @Query("select * from public.user as u where u.login = :login and u.passw = :passw")
    User findUserByLoginAndPassw(@Param("login") String login, @Param("passw") String passw);
}
