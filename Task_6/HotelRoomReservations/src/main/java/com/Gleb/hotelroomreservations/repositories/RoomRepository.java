package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

    Room getById(int id);
}
