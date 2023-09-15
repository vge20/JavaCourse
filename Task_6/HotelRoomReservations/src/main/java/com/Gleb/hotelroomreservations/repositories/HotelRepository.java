package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Optional<Hotel>, Integer> {

    List<Optional<Hotel>> findHotelsByLocation(String location);
}
