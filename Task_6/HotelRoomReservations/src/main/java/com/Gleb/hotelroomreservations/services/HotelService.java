package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.*;
import com.Gleb.hotelroomreservations.repositories.HotelRepository;
import com.Gleb.hotelroomreservations.repositories.ReservationRepository;
import com.Gleb.hotelroomreservations.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class HotelService implements BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Hotel getByIdImpl(int id) {
        return this.hotelRepository.findHotelById(id);
    }

    @Override
    @Transactional
    public void deleteByIdImpl(int id) {
        this.hotelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Hotel saveObjectImpl(Object object) {
        return this.hotelRepository.save((Hotel) object);
    }

    @Transactional
    public List<OptionForReserve> getDataForReserve(ConditionsForReserve conditionsForReserve)
            throws WorkingWithDBException {
        List<Hotel> hotels;
        List<Integer> vacantRoomsId;
        List<Room> rooms;
        try {
            hotels = hotelRepository.findHotelsByLocation(conditionsForReserve.getLocation());
            vacantRoomsId = reservationRepository.findVacantRoomsId(conditionsForReserve.getStartDate(),
                    conditionsForReserve.getEndDate());
            rooms = roomRepository.getAllRooms();
        } catch (Exception e) {
            throw new WorkingWithDBException();
        }
        if (hotels == null || vacantRoomsId == null || rooms == null) throw new WorkingWithDBException();

        List<OptionForReserve> optionsForReserves = new LinkedList<>();
        for (int i = 0; i < hotels.size(); i++) {
            for (int j = 0; j < rooms.size(); j++) {
                for (int k = 0; k < vacantRoomsId.size(); k++) {
                    if (hotels.get(i).getId() == rooms.get(j).getHotelId()
                            && rooms.get(j).getId() == vacantRoomsId.get(k)) {
                        optionsForReserves.add(new OptionForReserve(hotels.get(i).getId(), rooms.get(j).getId()));
                    }
                }
            }
        }

        return optionsForReserves;
    }
}
