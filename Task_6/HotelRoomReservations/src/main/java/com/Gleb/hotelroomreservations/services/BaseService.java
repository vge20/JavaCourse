package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import org.springframework.data.repository.CrudRepository;

public class BaseService<T> {

    protected T getObject(CrudRepository<T, Integer> repository, int id) throws WorkingWithDBException {

        T object = (T) repository.findById(id);
        if (object == null) {
            throw new WorkingWithDBException();
        }

        return object;
    }
}
