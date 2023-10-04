package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.models.Room;
import com.Gleb.hotelroomreservations.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService implements BaseService<Room> {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room getByIdImpl(int id) {
        return this.roomRepository.findRoomById(id);
    }

    @Override
    @Transactional
    public void deleteByIdImpl(int id) {
        this.roomRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Room saveObjectImpl(Object object) {
        return this.roomRepository.save((Room) object);
    }
}
