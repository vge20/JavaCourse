package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.ValidationException;
import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.services.BaseService;
import com.Gleb.hotelroomreservations.validators.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController<T> {

    protected ResponseEntity<Object> getObjectById(Validator validator, BaseService<T> service, int id) {
        Object object;
        try {
            validator.validateId(id);
            object = service.getById(id);
        } catch (WorkingWithDBException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.NOT_FOUND);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    protected ResponseEntity<Object> deleteObjectById(Validator validator, BaseService<T> service, int id) {
        try {
            validator.validateId(id);
            service.deleteById(id);
        } catch (WorkingWithDBException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.NOT_FOUND);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    protected ResponseEntity<Object> saveObject(Validator validator, BaseService<T> service,
                                                Object object, boolean isAdd) {
        try {
            if (isAdd) validator.validateForAdd(object);
            else validator.validateForUpdate(object);
            service.saveObject((T) object);
        } catch (WorkingWithDBException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.BAD_REQUEST);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
