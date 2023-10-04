package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.Hotel;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    Hotel findHotelById(int id);

    @Query("select * from hotel")
    List<Hotel> getHotelsList();

    @Query("select id from hotel where location = :location")
    ArrayList<Integer> findHotelsIdByLocation(String location);
}
