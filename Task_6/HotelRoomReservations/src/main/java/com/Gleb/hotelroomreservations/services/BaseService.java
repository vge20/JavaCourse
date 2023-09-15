package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class BaseService<T> {

    protected Optional<T> getObject(CrudRepository<Optional<T>, Integer> repository, int id) throws WorkingWithDBException {

        Optional<T> object = (Optional<T>) repository.findById(id);
        if (object == null) {
            throw new WorkingWithDBException();
        }

        return object;
    }
}
