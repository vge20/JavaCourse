package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Optional<User>, Integer> {}
