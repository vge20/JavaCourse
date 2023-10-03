package com.Gleb.hotelroomreservations.exceptions;

public class NotFoundException extends BaseException {

    private String message;

    public NotFoundException() {
        message = "message:Ошибка при работе с БД!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
