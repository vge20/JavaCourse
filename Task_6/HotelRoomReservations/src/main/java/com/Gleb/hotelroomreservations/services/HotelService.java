package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.NotFoundException;
import com.Gleb.hotelroomreservations.models.*;
import com.Gleb.hotelroomreservations.repositories.HotelRepository;
import com.Gleb.hotelroomreservations.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class HotelService implements BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservationRepository reservationRepository;

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
            throws NotFoundException {
        List<Integer> hotelsId;
        List<OptionForReserve> optionsForReserves;
        try {
            hotelsId = hotelRepository.findHotelsIdByLocation(conditionsForReserve.getLocation());
            optionsForReserves = reservationRepository.findVacantRoomsId(conditionsForReserve.getStartDate(),
                    conditionsForReserve.getEndDate());
        } catch (Exception e) {
            throw new NotFoundException();
        }
        if (hotelsId == null || optionsForReserves == null) throw new NotFoundException();

        for (int i = 0; i < optionsForReserves.size(); i++) {
            if (!hotelsId.contains(optionsForReserves.get(i).getHotelId()))
                optionsForReserves.remove(i);
        }

        return optionsForReserves;
    }
}
