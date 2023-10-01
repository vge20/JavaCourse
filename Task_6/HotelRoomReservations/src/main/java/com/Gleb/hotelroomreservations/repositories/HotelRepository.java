package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    Hotel findHotelById(int id);

    ArrayList<Hotel> findHotelsByLocation(String location);
}
