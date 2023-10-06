package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.*;
import com.Gleb.hotelroomreservations.repositories.HotelRepository;
import com.Gleb.hotelroomreservations.repositories.ReservationRepository;
import com.Gleb.hotelroomreservations.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class HotelService implements BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Hotel getByIdImpl(int id) {
        return this.hotelRepository.findHotelById(id);
    }

    public List<Hotel> getHotelsList() throws WorkingWithDBException {
        List<Hotel> hotels;
        try {
            hotels = hotelRepository.getHotelsList();
        } catch (Exception e) {
            throw new WorkingWithDBException();
        }
        return hotels;
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
    public List<Room> getDataForReserve(ConditionsForReserve conditionsForReserve)
            throws WorkingWithDBException {
        List<Integer> hotelsInLocationId;
        List<Room> roomsList;
        List<Integer> reservedRoomsId;
        try {
            hotelsInLocationId = hotelRepository.findHotelsIdByLocation(conditionsForReserve.getLocation());
            roomsList = roomRepository.getRoomsList();
            reservedRoomsId = reservationRepository.findReservedRoomsId(conditionsForReserve.getStartDate(),
                    conditionsForReserve.getEndDate());
        } catch (Exception e) {
            throw new WorkingWithDBException();
        }
        if (hotelsInLocationId == null || reservedRoomsId == null || roomsList == null)
            throw new WorkingWithDBException();

        List<Room> optionsForReserve = new ArrayList<>();

        for (int i = 0; i < roomsList.size(); i++) {
            if (hotelsInLocationId.contains(roomsList.get(i).getHotelId()) &&
                    !reservedRoomsId.contains(roomsList.get(i).getId())) {
                optionsForReserve.add(roomsList.get(i));
            }
        }

        return optionsForReserve;
    }
}
