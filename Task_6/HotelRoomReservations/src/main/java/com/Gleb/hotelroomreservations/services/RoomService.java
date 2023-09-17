package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.Room;
import com.Gleb.hotelroomreservations.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements BaseService<Room> {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room getByIdImpl(int id) {
        return this.roomRepository.findRoomById(id);
    }

    @Override
    public boolean deleteByIdImpl(int id) {
        return this.roomRepository.deleteRoomById(id);
    }

    @Override
    public Room saveObjectImpl(Object object) {
        return this.roomRepository.save((Room) object);
    }
}
