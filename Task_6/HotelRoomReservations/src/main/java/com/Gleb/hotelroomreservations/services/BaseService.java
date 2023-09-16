package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;

public interface BaseService<T> {

    T getById(int id) throws WorkingWithDBException;

    void deleteById(int id) throws WorkingWithDBException;
}
