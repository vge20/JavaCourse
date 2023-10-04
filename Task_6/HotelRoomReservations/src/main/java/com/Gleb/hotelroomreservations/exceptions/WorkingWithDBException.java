package com.Gleb.hotelroomreservations.exceptions;

public class NotFoundException extends BaseException {

    private String message;

    public NotFoundException() {
        message = "message:Не найдено такой записи в БД!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
