package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.Room;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

    Room findRoomById(int id);

    @Query("select * from room")
    List<Room> getRoomsList();
}
