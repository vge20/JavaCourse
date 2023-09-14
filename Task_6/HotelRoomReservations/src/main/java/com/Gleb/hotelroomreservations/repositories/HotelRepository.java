package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    List<Hotel> findHotelsByLocation(String location);

    Hotel findHotelById(int id);
}
